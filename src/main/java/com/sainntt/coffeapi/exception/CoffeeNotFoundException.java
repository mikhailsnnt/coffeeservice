package com.sainntt.coffeapi.exception;

public class CoffeeNotFoundException extends RuntimeException{

    public CoffeeNotFoundException(long id) {
        super("Coffee with id = {"+id+"} not found");
    }

    public CoffeeNotFoundException(String name){
        super("Coffee {"+name+"} not found");
    }

}
