package com.yize.collection;

import org.junit.Test;

import java.util.*;
import java.util.Hashtable;
import java.util.LinkedHashMap;

public class HashTest {
    @Test
    public void test(){
        LinkedHashMap<String,Integer> map=new LinkedHashMap<>();
        HashSet<Integer> hashSet=new HashSet<>();
        hashSet.add(1);
        hashSet.contains(1);

        map.put("1",1);
        map.put("ss1",1);
        map.put("1ttt",1);
        map.put("1555",1);
        map.remove("1555");
        map.containsKey("1555");

        map.containsValue(1);
        for (String i:map.keySet()){
            System.out.println(i);
        }
        System.out.println("_______________");
        for (Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry);
        }

        System.out.println("_______________");
        Hashtable<Integer,Integer> hashtable=new Hashtable<>();
        hashtable.put(Integer.valueOf(1),1);
        hashtable.put(Integer.valueOf(2),2);
        hashtable.put(Integer.valueOf(100),100);
        System.out.println();
        for (Integer i:hashtable.keySet()){
            System.out.println(hashtable.get(i));
        }
        System.out.println("***********************");
        for (Map.Entry<Integer,Integer> entry:hashtable.entrySet()){
            System.out.println(entry.getKey());
        }



    }
    @Test
    public void test1(){
        convertToBEB(552683);
        System.out.println(hash(552683));
        System.out.println(hash(552675));

//        convertToBEB(65537^(65537>>>16));
//        HashMap<Integer,Integer> map=new HashMap<>();
//        for (int i=0;i<Integer.MAX_VALUE;i++){
//            if(!map.containsKey(i)){
//                map.put(hash(i),i);
//            }else {
//                System.out.println(i+""+map.get(hash(i)));
//            }
//            if(i%1000000==0){
//                System.out.println(i);
//            }
//        }
    }

    static final int hash(Object key) {
        int h;
        return (key==null)?0:(h=key.hashCode())^(h>>>16);
    }

    public void convertToBEB(int n){
        for (int i=31;i>=0;i--){
            if((n&1<<i)!=0){
                System.out.print(1);
            }else {
                System.out.print(0);
            }
            if(i%4==0){
                System.out.print("\t");
            }
        }
        System.out.println();
    }
}
