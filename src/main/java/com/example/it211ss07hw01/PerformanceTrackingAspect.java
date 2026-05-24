package com.example.it211ss07hw01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTrackingAspect {

    @Around("execution(* com.example.it211ss07hw01.TransactionService.processPayment())")
    public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("LOG: " + methodName + " chạy trong " + (endTime - startTime) + "ms");

        return result;
    }
}