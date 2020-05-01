package com.yize.common;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        int k=in.nextInt();
        char cs[]=str.toCharArray();
        for(int i=0;i<cs.length;i++){

        }



    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        char[] cs=in.nextLine().toCharArray();
//        if(cs.length==0){
//            System.out.println(0);
//            return;
//        }
//        int[] map=new int[128];//使用数组实现hash
//        for (char c:cs){
//            map[c]++;
//        }
//        long total=recursion(cs.length);
//        for (int i=0;i<map.length;i++){
//            total=total/recursion(map[i]);
//        }
//        System.out.println(total);
//    }
//    //计算阶乘，非递归，防止递归导致栈溢出,使用long防止整数溢出
//    public static long recursion(int n){
//        long m=1;
//        while(n>0){
//            m=m*n;
//            n=n-1;
//        }
//        return m;
//    }
}
