package com.sainntt.coffeapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CoffeeRecipe {
    private int id;
    private String name;
    private Map<String, Long> ingredientsOnAmount;
}
