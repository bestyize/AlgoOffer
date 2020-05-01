package com.yize.thread;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    private static int count=0;
    public static void main(String[] args) {

        //Executor executor =Executors.newFixedThreadPool(5);
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (ThreadPoolDemo.class){
                            for (int i=0;i<10000;i++){
                                //Thread.sleep((long)(Math.random()*10));
                                //System.out.println(Thread.currentThread().getName());
                                count++;
                            }
                        }
                        System.out.println(Thread.currentThread().getName());


                        } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        while (executorService.isTerminated()==false){

        }
        System.out.println(count);


        
    }
}
