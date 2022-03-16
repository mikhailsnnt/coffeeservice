package com.sainntt.coffeapi.repository;

import com.sainntt.coffeapi.entity.RecipeElement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptElementRepository extends JpaRepository<RecipeElement, Long> {
}
