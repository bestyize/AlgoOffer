package com.yize.jvm.memory;

import org.junit.Test;

public class GCTest {

    public static void main(String[] args) throws InterruptedException {
        byte b[]=new byte[Integer.MAX_VALUE];
        System.gc();
        System.out.println("***************");
        int a=b.length;
        b=null;
        Thread.sleep(400);
        System.gc();
        System.out.println("***************");
        System.out.println(b);

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

    }
}
