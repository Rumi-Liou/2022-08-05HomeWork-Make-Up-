package com.example.shoppingcar.Exception;

public class PointExistException extends RuntimeException {
    public PointExistException(int id) {
        super(id + " is Exist");
    }
}
