package com.example.aop.demo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

    private Logger LOGGER = LoggerFactory.getLogger(UserAccessAspect.class);

    //Weaving & Weaver

    //@Before("execution(* com.example.aop.demo.aop.business.*.*(..))")
    //Pointcut
    //@Before("execution(* com.example.aop.demo.aop..*.*(..))")
    @Before("com.example.aop.demo.aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void before(JoinPoint joinPoint) {
        //Advice
        LOGGER.info("Checking user access permissions");
        LOGGER.info("Granted Access {}", joinPoint);
    }
}
