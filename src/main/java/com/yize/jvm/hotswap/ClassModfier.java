package com.yize.jvm.hotswap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ClassModfier {
    public static void main(String[] args) {
//        Integer a=1;
//        Integer b=2;
//        Integer g=3;
//        String s="";
//        s.equals("");
//        HashMap<Integer,Integer> map=new HashMap<>();
//        String s1="123";
//
//        s1.trim();
//        System.out.println(s1.intern());
//
//        System.out.println(g.equals(a+b));
        String s=new String("1");
        //s.intern();
        String s2="1";
        String s3="1";
        StringBuilder sb=new StringBuilder();
        sb.append("1");
        StringBuffer sbb=new StringBuffer();
        sbb.append("1");
        Integer i=1000;
        
        System.out.println(s3==s2);
    }
}
