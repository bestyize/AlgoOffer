package com.yize.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子更新数组
 */
public class AtomicIntegerArrayTest {
    static int[] value=new int[]{1,2};
    //这里会克隆一份数组，而不是传递引用
    static AtomicIntegerArray ai=new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);

        ai.compareAndSet(0,ai.get(0)+1,2);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
