package com.example.project3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Project3Aspect {

    @Pointcut("execution(* com.example.project3.*.*(..))")
    public void allMethods() {}

    @After("allMethods()")
    public void addLog( final JoinPoint joinPoint ) {
        if(joinPoint.getSignature().getName().contains("get"))
            System.out.println("Method only reads data");
        else
            System.out.println("Method will manipulate data");
    }
}
