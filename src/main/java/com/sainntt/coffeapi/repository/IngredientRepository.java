package com.sainntt.coffeapi.repository;

import com.sainntt.coffeapi.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> getByName(String ingredientName);
}
