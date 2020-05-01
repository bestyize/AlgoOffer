package com.yize.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.*;

//ScheduledThreadPoolExecutor继承ThreadPoolExecutor。他的主要作用是用来在给定的延迟后执行任务，或者定期执行任务。，功能和Timer类似
//但ScheduledThreadPoolExecutor可以在构造函数中指定多个对应的后台线程数，Timer只能对应一个
public class ScheduledThreadPoolTest {
    class ScheduleTaskT implements RunnableScheduledFuture<Integer>{

        @Override
        public boolean isPeriodic() {
            return false;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }

        @Override
        public void run() {

        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            return false;
        }

        @Override
        public boolean isCancelled() {
            return false;
        }

        @Override
        public boolean isDone() {
            return false;
        }

        @Override
        public Integer get() throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }

    @Test
    public void test(){
        /**
         * ScheduledThreadPoolExecutor中的DelayQueue是一个无界队列，所以设置maximumPoolSize没有效果。
         * 1、当调用ScheduledThreadPoolExecutor的scheduleAtFixedRate()或者scheduleWithFixedDelay()方法时，会向
         * ScheduledThreadPoolExecutor的DelayQueue添加一个实现了RunnableScheduledFuture接口的ScheduledFutureTask。
         * 2、线程池中的线程从DelayQueue中获取ScheduleFutureTask,然后执行任务
         *
         * 为了实现周期性的执行任务，对ThreadPoolExecutor做了如下的修改：
         *  1、使用DelayQueue作为任务队列。
         *  2、获取任务的方式不同
         *
         *  ScheduledThreadPoolExecutor会把调度的任务（ScheduledFutureTask）放到一个DelayQueue中
         *  ScheduleFutureTask主要包含三个成员变量，如下：
         *      long型成员变量time,表示任务执行的具体时间
         *      long型变量sequenceNumber，表示任务被添加到ScheduledThreadPoolExecutor中的序号
         *      long型变量period，表示任务执行的间隔周期
         *  DelayQueue封装了一个PriorityQueue,他对ScheduledFutureTask进行了排序。排序时time小的排在前面。，如果两个任务时间相同
         *  那么sequenceNumber小的先执行(先提交的先执行)
         *
         *  ScheduleFutureTask执行的四个步骤：
         *      1、线程 1从DelayQueue中获取已到期的ScheduleFutureTask(DelayQueue.take()).
         *      2、线程1执行这个ScheduledFutureTask。
         *      3、线程1修改ScheduledFutureTask的time变量为下次要被执行的时间。
         *      4、线程1把这个修改后的任务放回DelayQueue中(DelayQueue.add())。
         *
         */
        //下面三句话是等价的，但是DelayedWorkQueue是ScheduledThreadPoolExecutor静态内部类，无法外部访问
        ScheduledThreadPoolExecutor executor= (ScheduledThreadPoolExecutor)Executors.newScheduledThreadPool(100);
        executor.execute(new ScheduleTaskT());
        DelayQueue delayQueue=new DelayQueue();
 //       delayQueue.take();
//        delayQueue.add()
        Executor executor1=new ScheduledThreadPoolExecutor(100);
        //Executor executor2=new ThreadPoolExecutor(100,Integer.MAX_VALUE,TimeUnit.NANOSECONDS,new DelayedWorkQueue<>());

    }
}
