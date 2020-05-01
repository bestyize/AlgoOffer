package com.yize.jvm.proxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DyncProxy {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Hello hello=new HelloProxy();
        InvocationHandler handler=new DyncProxyHandler(hello);
        Hello proxyHello=(Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(),hello.getClass().getInterfaces(),handler);
        proxyHello.sayHello();
    }
}
