package com.yize.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class ForkJoinCounterTask extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private volatile static int THRESHOLD=2;

    public ForkJoinCounterTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum=0;
        //如果任务规模小于阈值就执行计算
        if(end-start<=THRESHOLD){
            for(int i=start;i<=end;i++){
                sum+=i;
            }
        }else {
            //如果任务规模大于阈值就分裂成两个子任务
            int middle=(start+end)>>1;
            ForkJoinCounterTask task1=new ForkJoinCounterTask(start,middle);
            ForkJoinCounterTask task2=new ForkJoinCounterTask(middle+1,end);
            //执行子任务
            task1.fork();
            task2.fork();
            //获取结果
            //其中task1.join()等返回任务执行结果
            sum+=task1.join()+task2.join();
        }
        return sum;
    }

}
