package com.cg.ems.ProjectCode.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectCodeException extends RuntimeException {

  public ProjectCodeException(String exception) {
    super(exception);
  }

}