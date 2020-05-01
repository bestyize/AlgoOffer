package com.yize.newcoder.kuaishou;

import java.util.Scanner;

public class T8 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int m=Integer.valueOf(in.nextLine());
        while(m-->0){
            String[] v=in.nextLine().split(" ");
            String v0=build(v[0]);
            String v1=build(v[1]);
            System.out.println(!compare(v0.split("\\."),v1.split("\\.")));

        }
    }

    public static boolean compare(String[] v0,String[] v1){
        for(int i=0;i<v0.length;i++){
            if(Integer.valueOf(v0[i])<Integer.valueOf(v1[i])){
                return false;
            }
        }
        return true;
    }

    public static String build(String s){
        char[] cs=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int numStart=0;
        int dotCount=0;
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='.'){
                sb.append(s.substring(numStart,i)+".");
                numStart=i+1;
                dotCount++;
            }
        }
        if(numStart<cs.length){
            sb.append(s.substring(numStart));
        }
        for(int i=dotCount;i<3;i++){
            sb.append(".0");
        }
        return sb.toString();
    }
}
