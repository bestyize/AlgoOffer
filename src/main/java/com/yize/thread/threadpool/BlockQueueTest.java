package com.yize.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueTest {
    private ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);
    int count=0;
    class Producter implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    queue.put(1);
                    count++;
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                try {
                    queue.take();
                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test() {
        for (int i=0;i<5;i++){
            new Thread(new Producter()).start();
            new Thread(new Consumer()).start();
        }
    }
}
