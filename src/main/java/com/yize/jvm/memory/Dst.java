package com.yize.jvm.memory;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Dst {
    private volatile static int counter=0;
    static class Pool{
        public int id;
        private String name;


    }
    private static final String lock="LOCK";
    public static void main(String[] args) {
        Gson gson=new Gson();
        List<String> list=new ArrayList<>();
        gson.fromJson("{}",new TypeToken<ArrayList<String>>(){}.getType());
        Pool pool=new Pool();
        synchronized (lock){
            pool.id++;
        }
    }
}
