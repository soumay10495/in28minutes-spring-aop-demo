package com.example.aop.demo.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

    @Pointcut("execution(* com.example.aop.demo.aop.dao.*.*(..))")
    public void dataLayerExecution() {
    }

    @Pointcut("execution(* com.example.aop.demo.aop.business.*.*(..))")
    public void businessLayerExecution() {
    }

    @Pointcut("bean(*Dao*)")
    public void beanContainingDao() {
    }

    @Pointcut("within(com.example.aop.demo.aop..*)")
    public void withinPackageAOP() {
    }

    @Pointcut("@annotation(com.example.aop.demo.aop.aspect.TrackTime)")
    public void trackTimeAnnotation() {
    }
}
