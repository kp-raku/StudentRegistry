package com.student.registry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody ExceptionResponse handleStudentNotFoundException(StudentNotFoundException exception, HttpServletRequest request){
        ExceptionResponse myResponse = new ExceptionResponse();
        myResponse.setErrorMessage(exception.getMessage());
        myResponse.setRequestURI(request.getRequestURI());
        return myResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody ExceptionResponse handleException(Exception exception, HttpServletRequest request){
        ExceptionResponse myResponse = new ExceptionResponse();
        myResponse.setErrorMessage(exception.getMessage());
        myResponse.setRequestURI(request.getRequestURI());
        return myResponse;
    }
}
