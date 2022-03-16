package com.sainntt.coffeapi.service;

import com.sainntt.coffeapi.dto.CoffeePreparationResult;

public interface CoffeePreparationService {
    CoffeePreparationResult prepareCoffee(int id);

    CoffeePreparationResult prepareCoffee(String name);
}
