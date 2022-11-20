package com.applaudostudios.week5assignment.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    public MyExceptionHandler(){

        super();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ApiError apiError =
                new ApiError(HttpStatus.BAD_REQUEST,ex.getClass().getSimpleName(), errors);
        return handleExceptionInternal(
                ex, apiError, headers, apiError.getStatus(), request);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {

        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex.getClass().getSimpleName(),errors);
        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {

        List<String> errors = new ArrayList<>();
        errors.add(ex.getMessage());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex.getClass().getSimpleName(),errors);
        return new ResponseEntity<>(apiError,apiError.getStatus());

    }
}
