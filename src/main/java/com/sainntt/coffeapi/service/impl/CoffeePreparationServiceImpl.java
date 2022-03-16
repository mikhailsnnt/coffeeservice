package com.sainntt.coffeapi.service.impl;

import com.sainntt.coffeapi.entity.Coffee;
import com.sainntt.coffeapi.entity.Ingredient;
import com.sainntt.coffeapi.exception.NotEnoughIngredientException;
import com.sainntt.coffeapi.exception.CoffeeNotFoundException;
import com.sainntt.coffeapi.repository.CoffeeRepository;
import com.sainntt.coffeapi.service.CoffeePreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoffeePreparationServiceImpl implements CoffeePreparationService {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeePreparationServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Transactional
    @Override
    public void prepareCoffee(int id) {
        if (!coffeeRepository.existsById(id))
            throw new CoffeeNotFoundException(id);
        Coffee coffee = coffeeRepository.getById(id);
        coffee.getIngredients().forEach(receiptElement -> {
            Ingredient ingredient = receiptElement.getIngredient();
            if (ingredient.getAmountLeft() < receiptElement.getAmount())
                throw new NotEnoughIngredientException(ingredient.getName(), receiptElement.getAmount() - ingredient.getAmountLeft());
            ingredient.setAmountLeft(ingredient.getAmountLeft() - receiptElement.getAmount());
        });
    }
}
