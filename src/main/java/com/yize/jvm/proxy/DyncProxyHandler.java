package com.yize.jvm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DyncProxyHandler implements InvocationHandler {
    private Object object;

    public DyncProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Invoke");
        method.invoke(object,args);
        System.out.println("After Invoke");
        return null;
    }
}
