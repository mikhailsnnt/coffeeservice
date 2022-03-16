package com.sainntt.coffeapi.exception;

public class NotEnoughIngredientException extends RuntimeException{
    private final String ingredientName;
    private final long amount;


    public NotEnoughIngredientException( String ingredientName, long amount) {
        super(String.format("Not enough of %s , need %d more",ingredientName,amount));
        this.ingredientName = ingredientName;
        this.amount = amount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public long getAmount() {
        return amount;
    }
}
