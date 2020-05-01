package com.yize.jvm.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class Singleton {
    public static AtomicInteger race=new AtomicInteger(0);
    public static void main(String[] args) {
        race.incrementAndGet();
    }
}
