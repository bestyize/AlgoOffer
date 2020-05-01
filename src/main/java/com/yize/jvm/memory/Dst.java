package com.yize.jvm.memory;

public class Dst {
    private volatile static int counter=0;
    static class Pool{
        public int id;
        private String name;


    }
    private static final String lock="LOCK";
    public static void main(String[] args) {
        Pool pool=new Pool();
        synchronized (lock){
            pool.id++;
        }
    }
}
