package com.example.aop.demo.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Aspect
@Configuration
public class PerformanceTestingAroundAspect {
    private Logger LOGGER = LoggerFactory.getLogger(PerformanceTestingAroundAspect.class);

    //@Around("execution(* com.example.aop.demo.aop.business.*.*(..))")
    @Around("com.example.aop.demo.aop.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        TimeUnit.SECONDS.sleep(1);
        long timeTaken = System.currentTimeMillis() - startTime;

        LOGGER.info("Time taken by {} is {}", joinPoint, timeTaken);
    }
}
