package com.yize.common;

import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadTTT {
    static Person person=null;


    public static void main(String[] args) throws InterruptedException {

        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue(5,false);
        blockingQueue.offer(1);
        LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<>();
        queue.offer(1);
        BlockingQueue<Integer> queue1=new SynchronousQueue<>();

        blockingQueue.offer(new Runnable() {
            @Override
            public void run() {

            }
        });
        ThreadFactory factory=new MyThreadFactory();
        RejectedExecutionHandler handler=new MyRejectHandler();
        ThreadPoolExecutor executor=new ThreadPoolExecutor(1,5,0
                , TimeUnit.SECONDS
                ,blockingQueue
                ,factory
                ,handler);
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });

        for (int i=0;i<10;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        //System.out.println(this.getClass().getName());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


    }
    static class MyRejectHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("MyRejectHandler:"+r);
        }
    }
    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    static class Person{
        public String name;

        public Person(String name) {
            this.name = name;
        }
    }

    static class A implements Runnable{
        public void run(){
            person=new Person("zhang");
        }
    }
    static class B implements Runnable{
        public void run(){

        }
    }
}
