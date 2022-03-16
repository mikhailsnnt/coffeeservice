package com.sainntt.coffeapi.exception;

public class IngredientNotFoundException extends RuntimeException{
    public IngredientNotFoundException(long id) {
        super("Ingredient with id {"+id+"} not found");
    }

    public IngredientNotFoundException(String name) {
        super("Ingredient with name {"+name+"} not found");
    }
}
