package com.sainntt.coffeapi.repository;

import com.sainntt.coffeapi.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
