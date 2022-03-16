package com.sainntt.coffeapi.service.impl;

import com.sainntt.coffeapi.dto.IngredientAmountDto;
import com.sainntt.coffeapi.entity.Ingredient;
import com.sainntt.coffeapi.exception.IngredientNotFoundException;
import com.sainntt.coffeapi.repository.IngredientRepository;
import com.sainntt.coffeapi.service.IngredientManagingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientManagingServiceImpl implements IngredientManagingService {
    private final IngredientRepository repository;

    public IngredientManagingServiceImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IngredientAmountDto> getIngredientsList() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientAmountDto getIngredientAmount(long id) {
        if (!repository.existsById(id))
            throw new IngredientNotFoundException(id);
        return mapToDto(repository.getById(id));
    }

    @Override
    public IngredientAmountDto getIngredientAmount(String name) {
        return mapToDto(repository.getByName(name).orElseThrow(() -> new IngredientNotFoundException(name)));
    }

    @Transactional
    @Override
    public void addIngredient(String name, long amount) {
        repository.getByName(name)
                .ifPresentOrElse(
                        ingredient -> ingredient.setAmountLeft(ingredient.getAmountLeft()+amount),
                        ()->{
                            Ingredient ingredient = new Ingredient();
                            ingredient.setAmountLeft(amount);
                            ingredient.setName(name);
                            repository.save(ingredient);
                        }
                );
    }

    private IngredientAmountDto mapToDto(Ingredient ingredient) {
        return new IngredientAmountDto(ingredient.getId(), ingredient.getName(), ingredient.getAmountLeft());
    }
}
