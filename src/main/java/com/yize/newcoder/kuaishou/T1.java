package com.yize.newcoder.kuaishou;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String nstr[]=in.nextLine().split(",");
        int nums[]=new int[nstr.length];
        for(int i=0;i<nstr.length;i++){
            nums[i]=Integer.valueOf(nstr[i]);
        }

        int max=0;
        int tempSum=0;
        for(int i=0;i<nums.length;i++){
            tempSum+=nums[i];
            if(tempSum>max){
                max=tempSum;
            }
            if(tempSum<0){
                tempSum=0;
            }
        }

        System.out.println(max);
    }
}
