package com.sainntt.coffeapi.service.impl;

import com.sainntt.coffeapi.dto.CoffeePreparationResult;
import com.sainntt.coffeapi.entity.Coffee;
import com.sainntt.coffeapi.entity.Ingredient;
import com.sainntt.coffeapi.exception.CoffeeNotFoundException;
import com.sainntt.coffeapi.exception.NotEnoughIngredientException;
import com.sainntt.coffeapi.repository.CoffeeRepository;
import com.sainntt.coffeapi.repository.IngredientRepository;
import com.sainntt.coffeapi.service.CoffeePreparationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CoffeePreparationServiceImpl implements CoffeePreparationService {
    private final CoffeeRepository coffeeRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public CoffeePreparationServiceImpl(CoffeeRepository coffeeRepository, IngredientRepository ingredientRepository) {
        this.coffeeRepository = coffeeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public CoffeePreparationResult prepareCoffee(int id) {
        if (!coffeeRepository.existsById(id))
            throw new CoffeeNotFoundException(id);
        return prepareCoffee(coffeeRepository.getById(id));
    }

    @Override
    public CoffeePreparationResult prepareCoffee(String name) {
        return prepareCoffee(coffeeRepository.getByName(name)
                .orElseThrow(() -> new CoffeeNotFoundException(name)));
    }

    @Transactional
    public CoffeePreparationResult prepareCoffee(Coffee coffee) {
        log.info("Preparing coffee {}",coffee);
        coffee.getIngredients().forEach(receiptElement -> {
            Ingredient ingredient = receiptElement.getIngredient();
            if (ingredient.getAmountLeft() < receiptElement.getAmount())
                throw new NotEnoughIngredientException(ingredient.getName(), receiptElement.getAmount() - ingredient.getAmountLeft());
            ingredient.setAmountLeft(ingredient.getAmountLeft() - receiptElement.getAmount());
            ingredientRepository.save(ingredient);
        });
        return new CoffeePreparationResult(coffee.getId(), coffee.getName());

    }
}
