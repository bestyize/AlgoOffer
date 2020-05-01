package com.yize.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {
    @Test
    public void test(){
        //下面两段都是创建固定大小线程池
        //keepAliveTime是在线程池中的线程数大于corePoolSize后，空闲线程等待新任务的最长时间，超过这个时间，多余的线程将会终止
        //所以，对于FixedThreadPool，keepAliveTime和maximumPoolSize参数无效。
        //此外LinkedBlockingQueue是无界队列。即大小不受限制，在线程池中任务数量达到corePoolSize时，新任务将在无界队列中等待，不会拒绝任务
        ThreadPoolExecutor fixedExecutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(100);
        ExecutorService fixedService=new ThreadPoolExecutor(100,100,0,TimeUnit.MICROSECONDS,new LinkedBlockingQueue<>());

        //下面是创建单个大小的Executor,两个也都是等价的
        Executor singleExecutor=Executors.newSingleThreadExecutor();
        Executor singelService=new ThreadPoolExecutor(1,1,0,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());

        //下面是可变大小的线程池,corePoolSize大小设置为0，maximumPoolSize设置为整数最大值，等待时间为60s，也就是说空闲线程超过60s后自动回收,使用同步队列
        //SynchronousQueue的容量为0，在生产时，如果没有消费，那么它将阻塞，https://zhuanlan.zhihu.com/p/29227508 这也意味着如果主线程
        //提交任务的速度超越处理任务的速度时，将会创建很多新线程，极端情况下，CachedThreadPool会因为创建过多进程而耗尽CPU和内存资源
        Executor cachedThreadPool=Executors.newCachedThreadPool();
        Executor cachedService=new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<>());
    }
}
