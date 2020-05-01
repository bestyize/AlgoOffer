package com.yize.jvm.memory;

public class TestVoilate {
    TestVoilate(){
        instance=new TestVoilate();
    }
    private static volatile TestVoilate instance;
    public static void main(String args[]){

    }
}
