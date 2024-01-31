package com.generation.italy.library.model.exceptions;

public class NoSuchEntityException extends Exception{
    public NoSuchEntityException(String message, Class<?> entity) {
        super(message + " entity: " + entity.getName());
    }
}
