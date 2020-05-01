package com.yize.thread;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureDemo {
    @Test
    public void test() throws ExecutionException, InterruptedException, IOException {
        FutureTask<String> futureTask=new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                OkHttpClient client=new OkHttpClient();
                Request request=new Request.Builder().url("http://www.baidu.com").build();
                Response response=client.newCall(request).execute();
                return response.body().string().toString();
            }
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        ConcurrentHashMap mm=new ConcurrentHashMap();
        mm.put(1,1);
        HashSet s=new HashSet();
        s.add(1);
    }
}
