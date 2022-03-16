package com.sainntt.coffeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public  class CoffeePreparationResult {
    private int coffeeId;
    private String name;
}
