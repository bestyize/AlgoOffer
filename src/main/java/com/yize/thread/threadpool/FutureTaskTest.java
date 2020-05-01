package com.yize.thread.threadpool;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    static class DownloadTask implements Runnable{
        private int taskId;

        public DownloadTask(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("run...");
        }
    }
    private final ConcurrentHashMap<Object, Future<String>> taskCache=new ConcurrentHashMap<>();

    private String executionTask(final String taskName) throws Exception{
        while (true){
            Future<String> future=taskCache.get(taskName);
            if(future==null){
                Callable<String> task=new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };
                FutureTask<String> futureTask=new FutureTask<>(task);
                future=taskCache.putIfAbsent(taskName,futureTask);
                if(future==null){
                    future=futureTask;
                    futureTask.run();
                }
            }
            try {
                future.get();
            }catch (Exception e){
                taskCache.remove(taskName,future);
            }

        }
    }


    @Test
    public void test() throws Exception{
        executionTask("123");
        executionTask("456");
        System.out.println("222");
    }



}
