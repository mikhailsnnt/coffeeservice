package com.sainntt.coffeapi.repository;

import com.sainntt.coffeapi.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

}
