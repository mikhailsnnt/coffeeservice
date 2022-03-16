package com.sainntt.coffeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class CoffeeRecipeDto {
    private int id;
    private String name;
    private Map<String, Long> ingredientsOnAmount;
}
