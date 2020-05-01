package com.yize.jvm.proxy;

public class HelloProxy implements Hello {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
