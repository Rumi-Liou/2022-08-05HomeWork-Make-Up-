package com.example.shoppingcar.Advice;

import com.example.shoppingcar.Exception.NotFoundException;
import com.example.shoppingcar.Exception.PointExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> NotFound(NotFoundException notFoundException) {
        return ResponseEntity.ok(notFoundException.getMessage());
    }

    @ExceptionHandler(PointExistException.class)
    public ResponseEntity<String> PointExist(PointExistException pointExistException) {
        return ResponseEntity.ok(pointExistException.getMessage());
    }

}
