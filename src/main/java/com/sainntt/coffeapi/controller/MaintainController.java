package com.sainntt.coffeapi.controller;

import com.sainntt.coffeapi.dto.IngredientAddDto;
import com.sainntt.coffeapi.dto.IngredientAmountDto;
import com.sainntt.coffeapi.service.IngredientManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintain/ingredients")
public class MaintainController {
    private final IngredientManagingService ingredientService;

    @Autowired
    public MaintainController(IngredientManagingService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PutMapping
    public ResponseEntity<IngredientAmountDto> addIngredient(@RequestBody IngredientAddDto dto) {
        return ResponseEntity.ok(ingredientService.addIngredient(dto.getName(), dto.getAmount()));
    }

    @GetMapping
    public ResponseEntity<List<IngredientAmountDto>> getIngredients() {
        return ResponseEntity.ok(ingredientService.getIngredientsList());
    }

    @GetMapping("/{ingredientId}")
    public ResponseEntity<IngredientAmountDto> getIngredientAmount(@PathVariable long ingredientId) {
        return ResponseEntity.ok(ingredientService.getIngredientAmount(ingredientId));
    }
}
