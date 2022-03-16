package com.sainntt.coffeapi.controller;

import com.sainntt.coffeapi.dto.CoffeeRecipeDto;
import com.sainntt.coffeapi.service.CoffeeRecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeInformationController {
    private final CoffeeRecipeService recipeService;

    public CoffeeInformationController(CoffeeRecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<CoffeeRecipeDto>> getRecipes() {
        return ResponseEntity.ok(recipeService.getRecipes());
    }

    @GetMapping("/coffee/{coffeeId}")
    public ResponseEntity<CoffeeRecipeDto> getRecipe(@PathVariable int coffeeId) {
        return ResponseEntity.ok(recipeService.getRecipe(coffeeId));
    }


}
