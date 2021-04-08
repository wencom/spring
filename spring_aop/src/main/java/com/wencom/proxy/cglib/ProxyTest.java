package com.wencom.proxy.cglib;


import com.wencom.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        final Target target = new Target();
        final Advice advice = new Advice();

        //创建增强器
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //前置通知
                advice.before();
                target.save();
                //后置通知
                advice.afterReturn();
                return null;
            }
        });

        //创建代理对象
        Target proxy = (Target) enhancer.create();
        proxy.save();
    }
}
