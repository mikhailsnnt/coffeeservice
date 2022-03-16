package com.sainntt.coffeapi.service;

import com.sainntt.coffeapi.dto.CoffeeRecipeDto;

public interface CoffeeRecipeService {
    CoffeeRecipeDto getRecipe(int coffeeId);
    CoffeeRecipeDto getRecipe(String coffeeName);
    void addIngredient(int coffeeId, String ingredientName, long ingredientAmount);
    void addIngredient(String coffeeName, String ingredientName, long ingredientAmount);
}