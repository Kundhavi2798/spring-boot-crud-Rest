package com.example.spring_boot_crud_Rest.exception;

public class SlotUnavailableException extends RuntimeException { 
    public SlotUnavailableException(String message) {
        super(message);
    }
}
