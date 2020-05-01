package com.yize.thread.atomic;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;
import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 原子更新基本类型
 */
public class AtomicIntegerTest {
     AtomicInteger atomicInteger=new AtomicInteger(0);
     private int counter=0;
     @Test
    public void test() throws InterruptedException {

        for (int i=0;i<100;i++){
                new Thread(() -> {
                    ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
                    threadLocal.set(0);
                    for (int i1 = 0; i1 <100; i1++){
                        threadLocal.set(threadLocal.get()+1);
                    }
                    counter+=threadLocal.get();
                    LockSupport.parkNanos(1);

                }).start();
        }

        Thread.sleep(1000);
        System.out.println(counter);
         ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    }
    class HttpRequestHelper implements Runnable{
         public void run(){

         }
    }
}
