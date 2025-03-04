package com.back_swing.back_swing.exceptions;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.back_swing.back_swing.utils.ResponseException;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(BadRequestException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleBadRequest(BadRequestException exception) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
  }

  @ExceptionHandler(ObjectNotFoundException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleObjectNotFound(ObjectNotFoundException exception) {
    return buildErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
  }

  @ExceptionHandler(DatabaseException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleDatabaseException(DatabaseException exception) {
    return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Ocurrió un error inesperado.");
  }

  @ExceptionHandler(NullPointerException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleNull(NullPointerException exception) {
    return buildErrorResponse(HttpStatus.NOT_ACCEPTABLE, "Error: Incomplete information.");
  }

  @ExceptionHandler(NumberFormatException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleNumberFormat(NumberFormatException exception) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, "Error: Wrong format request.");
  }

  @ExceptionHandler(InvalidKeyException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleInvalidKey(InvalidKeyException exception) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, "Error: Invalid information.");
  }

  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleSQLIntegrityConstraintViolation(
      SQLIntegrityConstraintViolationException exception) {
    return buildErrorResponse(HttpStatus.BAD_REQUEST, "Error: Not valid information.");
  }

  @ExceptionHandler(NoSuchAlgorithmException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleNoSuchAlgorithm(NoSuchAlgorithmException exception) {
    return buildErrorResponse(HttpStatus.NO_CONTENT, "Error: Suitable information not found.");
  }

  @ExceptionHandler(NoSuchPaddingException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleNoSuchPadding(NoSuchPaddingException exception) {
    return buildErrorResponse(HttpStatus.NOT_ACCEPTABLE, "Error: Not such information.");
  }

  @ExceptionHandler(IllegalBlockSizeException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleIllegalBlockSize(IllegalBlockSizeException exception) {
    return buildErrorResponse(HttpStatus.NOT_ACCEPTABLE, "Error: Illegal size.");
  }

  @ExceptionHandler(BadPaddingException.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleBadPadding(BadPaddingException exception) {
    return buildErrorResponse(HttpStatus.NOT_ACCEPTABLE, "Error: Bad Pad information.");
  }

  @ExceptionHandler(Exception.class)
  public Mono<ResponseEntity<Map<String, Object>>> handleGenericException(Exception exception) {
    return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error inesperado.");
  }

  private Mono<ResponseEntity<Map<String, Object>>> buildErrorResponse(HttpStatus status, String message) {
    return Mono.just(ResponseEntity.status(status).body(ResponseException.createApiException(false, message, null)));
  }
}
