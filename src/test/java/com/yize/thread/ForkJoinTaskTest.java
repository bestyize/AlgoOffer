package com.yize.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinTaskTest {
    @Test
    public void test(){
        //ForkJoinTask需要经过ForkJoinPool调用
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinCounterTask forkJoinCounterTask=new ForkJoinCounterTask(1,100);
        Future<Integer> result=forkJoinPool.submit(forkJoinCounterTask);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
