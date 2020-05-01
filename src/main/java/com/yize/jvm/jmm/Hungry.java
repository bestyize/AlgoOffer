package com.yize.jvm.jmm;

public class Hungry {
    private static Hungry instance=new Hungry();
    private Hungry(){}
    public static Hungry getInstance(){
        return instance;
    }
}
