package com.example.produktapi.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Integer id) {
        super(String.format("Produkt med id %d hittades inte", id));
    }
}

