package com.hostela.userlogin.globalexceptionhandler;


import com.hostela.userlogin.customexception.CustomException;
import com.hostela.userlogin.customexception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> customException(CustomException e) {
        ErrorResponse er = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> customException(Exception e) {
        ErrorResponse er = new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
