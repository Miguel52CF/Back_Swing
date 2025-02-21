package com.back_swing.back_swing.exceptions;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public Mono<ResponseEntity<String>> handleObjectNotFound(ObjectNotFoundException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Object not found."));
  }

  @ExceptionHandler(NullPointerException.class)
  public Mono<ResponseEntity<String>> handleNull(NullPointerException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: Incomplete information."));
  }

  @ExceptionHandler(NumberFormatException.class)
  public Mono<ResponseEntity<String>> handleNumberFormat(NumberFormatException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Wrong format request."));
  }

  @ExceptionHandler(InvalidKeyException.class)
  public Mono<ResponseEntity<String>> handleInvalidKey(InvalidKeyException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Invalid information."));
  }

  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public Mono<ResponseEntity<String>> handleSQLIntegrityConstraintViolation(
      SQLIntegrityConstraintViolationException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Not valid information."));
  }

  @ExceptionHandler(NoSuchAlgorithmException.class)
  public Mono<ResponseEntity<String>> handleNoSuchAlgorithm(NoSuchAlgorithmException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error: Suitable information not found."));
  }

  @ExceptionHandler(NoSuchPaddingException.class)
  public Mono<ResponseEntity<String>> handleNoSuchPadding(NoSuchPaddingException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: Not such information."));
  }

  @ExceptionHandler(IllegalBlockSizeException.class)
  public Mono<ResponseEntity<String>> handleIllegalBlockSize(IllegalBlockSizeException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: Illegal size."));
  }

  @ExceptionHandler(BadPaddingException.class)
  public Mono<ResponseEntity<String>> handleBadPadding(BadPaddingException exception) {
    return Mono.just(ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: Bad Pad information."));
  }
}
