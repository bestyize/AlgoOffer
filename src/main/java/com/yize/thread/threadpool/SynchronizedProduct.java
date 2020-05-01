package com.yize.thread.threadpool;

import org.junit.Test;

public class SynchronizedProduct {
    private static final String LOCK="lock";
    private static final Integer FULL=10;
    private int currentProduct=0;
    class Producter implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                synchronized (LOCK){
                    while (currentProduct==FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    currentProduct++;
                    System.out.println("生产者"+Thread.currentThread().getName()+"正在生产："+currentProduct);
                    LOCK.notifyAll();
                }
            }
        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                synchronized (LOCK){
                    while (currentProduct==0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    currentProduct--;
                    System.out.println("消费者"+Thread.currentThread().getName()+"进行消费："+currentProduct);
                    LOCK.notifyAll();
                }
            }
        }
    }
    @Test
    public void test(){
        for(int i=0;i<5;i++){
            new Thread(new Producter()).start();
            new Thread(new Consumer()).start();
        }
        while (true);
    }
}
