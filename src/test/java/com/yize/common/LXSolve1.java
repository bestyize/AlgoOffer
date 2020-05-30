package com.yize.common;

import java.util.Scanner;

public class LXSolve1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int d=in.nextInt();
        int upBound= (int) Math.pow(d,1.0/3.0)+1;
        int target=(int)Math.pow(d,3);
        int count=0;
        for(int a=0;a<upBound;a++){
            for (int b=a;b<upBound;b++){
                for (int c=b;c<upBound;c++){
                    int sum=(int)(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3));
                    if(sum==target){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
