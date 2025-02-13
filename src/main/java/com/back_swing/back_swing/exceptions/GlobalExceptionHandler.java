package com.back_swing.back_swing.exceptions;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<String> handleObjectNotFound(ObjectNotFoundException exception) {
    return new ResponseEntity<>("Error: Object not found.", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<String> handleNull(NullPointerException exception) {
    return new ResponseEntity<>("Error: Incomplete information.", HttpStatus.NOT_ACCEPTABLE);
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<String> handleNumberFormat(NumberFormatException exception) {
    return new ResponseEntity<>("Error: Wrong format request.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(InvalidKeyException.class)
  public ResponseEntity<String> handleInvalidKey(InvalidKeyException exception) {
    return new ResponseEntity<>("Error: Invalid information.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
  public ResponseEntity<String> handleSQLIntegrityConstraintViolation(SQLIntegrityConstraintViolationException exception) {
    return new ResponseEntity<>("Error: Not valid information.", HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoSuchAlgorithmException.class)
  public ResponseEntity<String> handleNoSuchAlgorithm(NoSuchAlgorithmException exception) {
    return new ResponseEntity<>("Error: Suitable information not found.", HttpStatus.NO_CONTENT);
  }

  @ExceptionHandler(NoSuchPaddingException.class)
  public ResponseEntity<String> handleNoSuchPadding(NoSuchPaddingException exception) {
    return new ResponseEntity<>("Error: Not such information.", HttpStatus.NOT_ACCEPTABLE);
  }

  @ExceptionHandler(IllegalBlockSizeException.class)
  public ResponseEntity<String> handleIllegalBlockSize(IllegalBlockSizeException exception) {
    return new ResponseEntity<>("Error: Illegal size.", HttpStatus.NOT_ACCEPTABLE);
  }

  @ExceptionHandler(BadPaddingException.class)
  public ResponseEntity<String> handleBadPadding(BadPaddingException exception) {
    return new ResponseEntity<>("Error: Bad Pad information.", HttpStatus.NOT_ACCEPTABLE);
  }

}
