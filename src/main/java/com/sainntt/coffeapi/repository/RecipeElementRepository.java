package com.sainntt.coffeapi.repository;

import com.sainntt.coffeapi.entity.RecipeElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeElementRepository extends JpaRepository<RecipeElement, Long> {
}
