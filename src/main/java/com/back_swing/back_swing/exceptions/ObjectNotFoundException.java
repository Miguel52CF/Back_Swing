package com.back_swing.back_swing.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ObjectNotFoundException extends ResponseStatusException {

    public ObjectNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(HttpStatus.NOT_FOUND, message, cause);
    }

    public ObjectNotFoundException(String message, HttpStatus status) {
        super(status, message);
    }
}
