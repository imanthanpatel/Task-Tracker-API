package com.TaskTracker.demo.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(InvalidStatusException.class)
    public String handleInvalidStatusException(InvalidStatusException exception){
            return exception.getMessage();
    }
    @ExceptionHandler(Exception.class)
    public String GenrealException(Exception exception){
        return "Unexcepted exception" + exception.getMessage();
    }

}
