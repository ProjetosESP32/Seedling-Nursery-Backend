package com.ifmt.gerenciamentoMudas;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ifmt.gerenciamentoMudas.exception.ErrorResponse;

//this will grab every runtime error
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
  public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
    ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
