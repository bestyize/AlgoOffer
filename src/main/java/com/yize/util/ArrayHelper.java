package com.yize.util;

public class ArrayHelper {
    public static void print(int[] a){
        if(a.length>0){
            for (int i=0;i<a.length;i++){
                System.out.print(a+"\t");
            }
        }
        System.out.println();
    }
    public static void print(String[] a){
        if(a.length>0){
            for (int i=0;i<a.length;i++){
                System.out.print(a+"\t");
            }
        }
        System.out.println();
    }
}
