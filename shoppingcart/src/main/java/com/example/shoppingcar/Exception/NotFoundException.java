package com.example.shoppingcar.Exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        // String message="id is not found";
        super(id + " is not found");
    }
}
