package com.springguru.testrestful.exceptions;

public class ProductAlreadyExistsException extends Exception {
    private String message;

    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
