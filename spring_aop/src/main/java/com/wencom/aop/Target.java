package com.wencom.aop;

import org.springframework.stereotype.Component;

@Component
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
//        throw new RuntimeException();
    }
}
