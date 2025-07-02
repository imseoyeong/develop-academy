package com.security_jwt.exception;

public class DuplicateIdException extends RuntimeException{
    public DuplicateIdException(String message){
        super(message);
    }
}
