package com.alloiz.alloizserver.service.validation;

public class IdException extends RuntimeException {

  private static String prefix = "ExceptionWithId:[";
  private String message;

  public IdException(String message) {
    this.message = prefix + message + "]";
  }

  @Override
  public String getMessage() {
    return message;
  }

}
