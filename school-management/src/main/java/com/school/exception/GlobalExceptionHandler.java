package com.school.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<String > myIllegalHandler(InvalidIdException ie){
        System.out.println("inside myhandler method");
        return new ResponseEntity<String>(ie.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
