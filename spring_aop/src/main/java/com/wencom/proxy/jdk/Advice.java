package com.wencom.proxy.jdk;

public class Advice {

    public void before() {
        System.out.println("前置通知...");
    }

    public void afterReturn() {
        System.out.println("后置通知...");
    }
}
