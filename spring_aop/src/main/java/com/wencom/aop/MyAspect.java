package com.wencom.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {

    public void before() {
        System.out.println("前置通知...");
    }

    public void afterReturning() {
        System.out.println("返回值通知...");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知-前...");
        Object proceed = joinPoint.proceed();
        System.out.println("环绕通知-后...");
        return proceed;
    }

    public void afterThrowing() {
        System.out.println("异常通知...");
    }

    public void after() {
        System.out.println("后置通知...");
    }

}
