package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerError(){
        return "/errorPage";
    }

    @ExceptionHandler(Exception.class)
    public String errorPage(){
        return "/errorPage";
    }
}
