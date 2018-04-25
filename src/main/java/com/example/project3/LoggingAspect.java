package com.example.project3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.example.project3.*.*(..))")
    public void allMethods() {}

    @After("allMethods()")
    public void addLog( final JoinPoint joinPoint ) {
        System.out.println("XExecuting: "+joinPoint.getSignature());

        Object[] arguments = joinPoint.getArgs();
        for (Object argument : arguments) {
            if (argument != null) {
                System.out.println("*** "+argument.getClass().getSimpleName() + " = " + argument);
            }
        }
    }

}
