package com.applaudostudios.week5assignment.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){

        super(message);
    }

}
