package com.sainntt.coffeapi.service.impl;

import com.sainntt.coffeapi.dto.CoffeeRecipeDto;
import com.sainntt.coffeapi.entity.Coffee;
import com.sainntt.coffeapi.entity.Ingredient;
import com.sainntt.coffeapi.entity.RecipeElement;
import com.sainntt.coffeapi.exception.CoffeeNotFoundException;
import com.sainntt.coffeapi.exception.IngredientNotFoundException;
import com.sainntt.coffeapi.repository.CoffeeRepository;
import com.sainntt.coffeapi.repository.IngredientRepository;
import com.sainntt.coffeapi.repository.RecipeElementRepository;
import com.sainntt.coffeapi.service.CoffeeRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class CoffeeRecipeServiceImpl implements CoffeeRecipeService {
    private final CoffeeRepository repository;
    private final IngredientRepository ingredientRepository;
    private final RecipeElementRepository recipeRepository;

    @Autowired
    public CoffeeRecipeServiceImpl(CoffeeRepository repository, IngredientRepository ingredientRepository, RecipeElementRepository recipeRepository) {
        this.repository = repository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public CoffeeRecipeDto getRecipe(int coffeeId) {
        if (!repository.existsById(coffeeId))
            throw new CoffeeNotFoundException(coffeeId);
        return formRecipe(repository.getById(coffeeId));
    }

    @Override
    public CoffeeRecipeDto getRecipe(String coffeeName) {
        return formRecipe(repository.getByName(coffeeName)
                .orElseThrow(() -> new CoffeeNotFoundException(coffeeName)));
    }

    @Override
    public void addIngredient(int coffeeId, String ingredientName, long ingredientAmount) {
        if (!repository.existsById(coffeeId))
            throw new CoffeeNotFoundException(coffeeId);
        Ingredient ingredient = ingredientRepository.getByName(ingredientName).orElseThrow(() -> new IngredientNotFoundException(ingredientName));
        Coffee coffee = repository.getById(coffeeId);
        addIngredient(coffee,ingredient,ingredientAmount);
    }

    @Override
    public void addIngredient(String coffeeName, String ingredientName, long ingredientAmount) {
        Coffee coffee = repository.getByName(coffeeName)
                .orElseThrow(() -> new CoffeeNotFoundException(coffeeName));
        Ingredient ingredient = ingredientRepository.getByName(ingredientName).orElseThrow(() -> new IngredientNotFoundException(ingredientName));
        addIngredient(coffee,ingredient,ingredientAmount);
    }

    private CoffeeRecipeDto formRecipe(Coffee coffee) {
        Map<String, Long> ingredientsOverAmount = new HashMap<>();
        coffee.getIngredients().forEach(ingredient -> ingredientsOverAmount.put(ingredient.getIngredient().getName(), ingredient.getAmount()));
        return new CoffeeRecipeDto(coffee.getId(),
                coffee.getName(),
                ingredientsOverAmount);
    }

    @Transactional
    public void addIngredient(Coffee coffee, Ingredient ingredient, long amount){
        RecipeElement recipeElement = new RecipeElement();
        recipeElement.setCoffee(coffee);
        recipeElement.setIngredient(ingredient);
        recipeElement.setAmount(amount);
        recipeRepository.save(recipeElement);
        coffee.getIngredients().add(recipeElement);
    }
}
