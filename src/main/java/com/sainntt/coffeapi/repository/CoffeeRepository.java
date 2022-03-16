package com.sainntt.coffeapi.repository;

import com.sainntt.coffeapi.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
    Optional<Coffee> getByName(String name);
}
