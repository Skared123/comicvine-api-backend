package com.gruposti.comicvine_api_backend.exception;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(String message) {
        super(message);
    }
}
