package com.ifmt.seedlingNursery.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy, hh:mm:ss")
  private LocalDateTime timeStamp;
  private List<String> message;

  public ErrorResponse(List<String> message) {
    this.message = message;
    this.timeStamp = LocalDateTime.now();
  }
}
