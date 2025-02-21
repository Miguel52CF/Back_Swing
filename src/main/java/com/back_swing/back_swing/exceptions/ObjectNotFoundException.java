package com.back_swing.back_swing.exceptions;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends RuntimeException {

    private final HttpStatus status;

    public ObjectNotFoundException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND; // Código de estado por defecto
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.status = HttpStatus.NOT_FOUND;
    }

    public ObjectNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status; // Permite definir un código de estado personalizado
    }

    public HttpStatus getStatus() {
        return status;
    }
}
