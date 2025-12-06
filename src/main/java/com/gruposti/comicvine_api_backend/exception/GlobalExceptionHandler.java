package com.gruposti.comicvine_api_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidLimitException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidLimit(InvalidLimitException ex) {
        return ResponseEntity.badRequest().body(Map.of(
                "type", "ERROR",
                "action", "CANCEL",
                "code", "INVALID_LIMIT",
                "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(CharacterNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCharacterNotFound(CharacterNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                "type", "ERROR",
                "action", "CANCEL",
                "code", "CHARACTER_NOT_FOUND",
                "message", ex.getMessage()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of(
                "type", "ERROR",
                "action", "CANCEL",
                "code", "INTERNAL_ERROR",
                "message", ex.getMessage()
        ));
    }
}
