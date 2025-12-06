package com.gruposti.comicvine_api_backend.exception;

public class InvalidLimitException extends RuntimeException {
    public InvalidLimitException(String message) {
        super(message);
    }
}
