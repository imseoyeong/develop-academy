package com.example.test_store_backend.exception;

public class MyException extends RuntimeException {
//    private String message;
//    public MyException(String message) {
//        this.message = message;
//    }
//    public String getMessage() {
//        return this.message;
//    }

    public MyException(String message) {
        super(message);
    }
}
