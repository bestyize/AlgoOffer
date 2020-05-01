package com.yize.common;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class DDD implements Callable<String> {
    private int count = 20;

    @Override
    public String call() throws Exception {
        for (int i = count; i > 0; i--) {
//			Thread.yield();
            System.out.println(Thread.currentThread().getName()+"当前票数：" + i);
        }
        return "sale out";
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable  =new DDD();
        FutureTask <String>futureTask=new FutureTask<>(callable);

        Thread mThread=new Thread(futureTask);
        Thread mThread2=new Thread(futureTask);
        Thread mThread3=new Thread(futureTask);
//		mThread.setName("hhh");
        mThread.start();
        mThread2.start();
        mThread3.start();
        System.out.println(futureTask.get());
        ThreadLocal<Integer> local=new ThreadLocal<>();
        local.get();
        Object obj=new Object();
        HashMap hashMap=new HashMap();
        HashMap<Object,Object> map=new HashMap<>();
        map.put(1,1);
        System.out.println(hashMap.hashCode());
        Callable<String> callable1=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
       //callable1.call();
       FutureTask<String> futureTask1=new FutureTask<>(callable1);
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().build();
        ExecutorService service= Executors.newCachedThreadPool();
        service.submit(callable1);
        int currentThreadNum=((ThreadPoolExecutor)service).getActiveCount();
        ThreadLocal<Object> threadLocal=new ThreadLocal<>();
        ReentrantLock lock=new ReentrantLock();
        lock.newCondition();
        lock.lock();
        Thread t=new Thread();
        t.start();
        BlockingQueue<String> blockingQueue=new LinkedBlockingQueue<>(1);
        ThreadPoolExecutor executor=new ThreadPoolExecutor(1,4,0,TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        ExecutorService service1=Executors.newFixedThreadPool(100);
        ExecutorService service2=Executors.newSingleThreadExecutor();
        ExecutorService service3=Executors.newCachedThreadPool();
        ExecutorService service4=Executors.newScheduledThreadPool(100);
        Semaphore semaphore=new Semaphore(10);
        semaphore.acquire();
        semaphore.release();
        service1.submit(new Runnable() {
            @Override
            public void run() {

            }
        });








    }
}
