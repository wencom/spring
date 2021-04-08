package com.wencom.proxy.jdk;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {

        final Target target = new Target();
        final Advice advice = new Advice();

        //代理对象
        TargetInterface proxy = (TargetInterface)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        method.invoke(target, args);
                        advice.afterReturn();
                        return null;
                    }
                }
        );

        proxy.save();
    }
}
