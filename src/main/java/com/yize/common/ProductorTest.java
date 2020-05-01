package com.yize.common;

import org.junit.Test;

import javax.naming.ldap.PagedResultsControl;
import java.util.concurrent.*;

public class ProductorTest {
    private static final String LOCK="LOCK";
    private int counter=0;
    private int MAX_NUM=10;

    class Productor implements Runnable{
        @Override
        public void run(){
            for (int i=0;i<5;i++){
                synchronized (LOCK){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (counter==MAX_NUM){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    counter++;
                    System.out.println("生产者"+Thread.currentThread().getName()+"生产产品："+counter);
                    LOCK.notifyAll();
                }

            }
            countDownLatch.countDown();

        }
    }
    class Consumer implements Runnable{
        @Override
        public void run(){
            while (true){
                synchronized (LOCK){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    while (counter==0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("消费者"+Thread.currentThread().getName()+"消费产品："+counter);
                    counter--;
                    LOCK.notifyAll();
                }
                if(countDownLatch.getCount()==1&&counter==0){
                    countDownLatch.countDown();
                }
            }
        }
    }
    private CountDownLatch countDownLatch=new CountDownLatch(11);
    @Test
    public void test() throws InterruptedException, ExecutionException {
//        Thread p=new Thread(new Productor(),"生产者");
//        Thread c=new Thread(new Consumer(),"消费者");

        ExecutorService service=Executors.newFixedThreadPool(20);
        for (int i=0;i<10;i++){
            service.submit(new Productor());
        }
        FutureTask<Void> futureTask= (FutureTask<Void>) service.submit(new Consumer());
        //futureTask.get();
        countDownLatch.await();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);



    }
}
