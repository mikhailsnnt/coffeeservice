package com.sainntt.coffeapi.controller;

import com.sainntt.coffeapi.dto.CoffeePreparationResult;
import com.sainntt.coffeapi.service.CoffeePreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffee/prepare/")
public class CoffeePreparationController {
    private final CoffeePreparationService service;

    @Autowired
    public CoffeePreparationController(CoffeePreparationService service) {
        this.service = service;
    }

    @GetMapping("/{coffeeId}")
    public ResponseEntity<CoffeePreparationResult> getCoffee(@PathVariable int coffeeId){
         return ResponseEntity.ok(service.prepareCoffee(coffeeId));
    }

}
