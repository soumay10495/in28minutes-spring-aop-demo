package com.example.aop.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {
    private Logger LOGGER = LoggerFactory.getLogger(AfterAspect.class);

    @After("execution(* com.example.aop.demo.aop.business.*.*(..))")
    public void after(JoinPoint joinPoint) {
        LOGGER.info("After execution of {}", joinPoint);
    }

    @AfterReturning(
            value = "com.example.aop.demo.aop.aspect.CommonJoinPointConfig.businessLayerExecution())",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        LOGGER.info("{} returned after execution of {}", result, joinPoint);
    }

    @AfterThrowing(
            value = "execution(* com.example.aop.demo.aop.business.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        LOGGER.info("{} throwing after execution of {} ", exception, joinPoint);
    }
}
