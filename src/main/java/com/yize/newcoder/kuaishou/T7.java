package com.yize.newcoder.kuaishou;

import java.util.Scanner;

public class T7 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int m=Integer.valueOf(in.nextLine());
        while(m-->0){
            int num=Integer.valueOf(in.nextLine());
            while(num!=1){
                int temp=getNextNum(num);
                if(temp==num){
                    System.out.println(false);
                    break;
                }
                num=temp;
            }
            if(num==1){
                System.out.println(true);
            }
        }

    }

    public static int getNextNum(int num){
        int result=0;
        while(num!=0){
            result+=(num%10)*(num%10);
            num/=10;
        }
        return result;
    }

}
