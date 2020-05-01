package com.yize.jvm.memory;

public class Test {

    public void finder(){
        int counter=0;
        synchronized (this){
            counter++;
        }
    }
}
