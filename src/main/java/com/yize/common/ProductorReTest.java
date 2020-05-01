package com.yize.common;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProductorReTest {
    private ReentrantLock LOCK=new ReentrantLock(true);
    private Condition notFull=LOCK.newCondition();
    private Condition notEmpty=LOCK.newCondition();
    private int counter=0;
    private static final int MAX=10;
    class Productor implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<5;i++){
                LOCK.lock();
                try {
                    //Thread.sleep(100);
                    while (counter==MAX){
                        try {
                            notFull.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    counter++;
                    System.out.println("生产者："+Thread.currentThread().getName()+"生产产品："+counter);
                    notEmpty.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    LOCK.unlock();
                }
            }
        }
    }
    class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<100;i++){
                LOCK.lock();
                try {
                    Thread.sleep(100);
                    while (counter==0){
                        notEmpty.await();
                    }
                    System.out.println("消费者："+Thread.currentThread().getName()+"消费产品："+counter);
                    counter--;
                    notFull.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    LOCK.unlock();
                }
            }
        }
    }

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService service= Executors.newCachedThreadPool();
        for (int i=0;i<20;i++){
            service.submit(new Productor());
        }
        FutureTask<Void> futureTask=(FutureTask)service.submit(new Consumer());
        futureTask.get();

    }
}
