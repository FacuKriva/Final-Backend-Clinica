package com.example.clinica_final_backend.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandler {

    private static final Logger logger = Logger.getLogger(GlobalHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errorLogger(Exception e, WebRequest w) {
        logger.error(e.getMessage());
        return new ResponseEntity("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}