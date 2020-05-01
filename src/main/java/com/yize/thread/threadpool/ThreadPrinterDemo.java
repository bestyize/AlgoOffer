package com.yize.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Executors.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印
 */
public class ThreadPrinterDemo {
    private ReentrantLock lock=new ReentrantLock();

    private Condition cond1=lock.newCondition();
    private Condition cond2=lock.newCondition();
    private Condition cond3=lock.newCondition();
    private char[] abc="ABC".toCharArray();

    @Test
    public void test() {
        ExecutorService es=Executors.newFixedThreadPool(3);
        es.submit(()->{
            while (true){
                lock.lock();
                try {
                    Thread.sleep(100);
                    cond1.await();
                    System.out.println(abc[0]);
                }catch (Exception e){
                    System.out.println(e.getCause());
                }finally {
                    cond2.signal();
                    lock.unlock();
                }
            }
        });
        es.submit(()->{
            while (true){
                lock.lock();
                try {
                    Thread.sleep(100);
                    cond2.await();
                    System.out.println(abc[1]);
                }catch (Exception e){
                    System.out.println(e.getCause());
                }finally {
                    cond3.signal();
                    lock.unlock();
                }
            }
        });
        es.submit(()->{
            while (true){
                lock.lock();
                try {
                    Thread.sleep(1);
                    cond3.await();
                    System.out.println(abc[2]);
                }catch (Exception e){
                    System.out.println(e.getCause());
                }finally {
                    cond1.signal();
                    lock.unlock();
                }
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                cond1.signal();
                lock.unlock();
            }
        }).start();

        while (true);



    }
}
