package com.rosajr.springmongo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
                                                        HttpServletRequest httpServletRequest) {

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;

        StandardError error = new StandardError(System.currentTimeMillis(), httpStatus.value(), "Não encontrado",
                e.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(httpStatus).body(error);
    }
}
