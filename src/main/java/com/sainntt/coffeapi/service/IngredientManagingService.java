package com.sainntt.coffeapi.service;

import com.sainntt.coffeapi.dto.IngredientAmountDto;

import java.util.List;

public interface IngredientManagingService {
    List<IngredientAmountDto> getIngredientsList();
    IngredientAmountDto getIngredientAmount(long id);
    IngredientAmountDto getIngredientAmount(String name);
    IngredientAmountDto addIngredient(String name, long amount);
}
