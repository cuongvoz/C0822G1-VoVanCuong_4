package com.codegym.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BookAOP {

    @Pointcut("execution(* com.codegym.controller.BookController.borrow(..))")
    public void callMethod(){
    }

    @Pointcut("execution(* com.codegym.controller.BookController.returnBorrow(..))")
    public void returnBorrow(){}

    @After("returnBorrow()")
    public void afterBorrow(JoinPoint joinPoint){
        System.err.println("Bạn đã trả sách bằng phương thức " + joinPoint.getSignature().getName());
    }

    @Before("callMethod()")
    public void beforeMethod(JoinPoint point) {
        System.err.println("Bạn đã mượn sách bằng phương thức " + point.getSignature().getName());
    }

}
