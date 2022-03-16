package com.sainntt.coffeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientAmountDto {
    private long id;
    private String name;
    private long amount;
}
