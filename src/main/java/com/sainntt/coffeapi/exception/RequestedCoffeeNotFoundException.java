package com.sainntt.coffeapi.exception;

public class RequestedCoffeeNotFoundException extends RuntimeException{
    private final long id;

    public RequestedCoffeeNotFoundException(long id) {
        super(String.valueOf(id));
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
