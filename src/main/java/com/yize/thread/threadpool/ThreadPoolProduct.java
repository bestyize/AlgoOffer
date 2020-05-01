package com.yize.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolProduct {
    private ReentrantLock lock=new ReentrantLock();
    private Condition producterCond=lock.newCondition();
    private Condition consumerCond=lock.newCondition();
    private int currProduct=0;
    private int maxProduct=10;
    class Producter implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                try {
                    while (currProduct==maxProduct){
                        producterCond.await();
                    }
                    System.out.println("生产者"+Thread.currentThread().getName()+"进行生产："+currProduct);
                    currProduct++;
                    consumerCond.signalAll();
                } catch (InterruptedException e) {
                    System.out.println(e.getCause());
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<10;i++){
                lock.lock();
                try {
                    while (currProduct==0){
                        consumerCond.await();
                    }
                    System.out.println("消费者"+Thread.currentThread().getName()+"进行消费："+currProduct);
                    currProduct--;
                    producterCond.signalAll();
                } catch (InterruptedException e) {
                    System.out.println(e.getCause());
                }finally {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void test(){
        ExecutorService es= Executors.newFixedThreadPool(20);

        for(int i=0;i<2;i++){
            new Thread(new Producter()).start();
            new Thread(new Consumer()).start();
        }

    }
}
