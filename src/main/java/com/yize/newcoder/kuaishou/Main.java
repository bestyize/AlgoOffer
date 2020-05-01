package com.yize.newcoder.kuaishou;

import org.junit.Test;

import java.util.*;
public class Main{


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String str[]=in.nextLine().split(",");
        int[] cost=new int[str.length];
        for(int i=0;i<cost.length;i++){
            cost[i]=Integer.valueOf(str[i]);
        }
        if(cost.length<2){
            System.out.println("0");
            return;
        }
        int[] dp=new int[cost.length];
        dp[0]=0;
        dp[1]=Math.min(dp[0]+cost[0],cost[1]);
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        System.out.println(dp[dp.length-1]);
    }

    public static void main1(String[] args){
        Scanner in=new Scanner(System.in);
        String costs[]=in.nextLine().split(",");
//        Scanner in=new Scanner(System.in);
//        String costs[]=in.nextLine().split(",");

        int[] cost=new int[costs.length];

        for(int i=0;i<cost.length;i++){
            cost[i]=Integer.valueOf(costs[i]);
        }
        if(cost.length<=2){
            System.out.println(cost[0]);
            return;
        }
        int[] dp=new int[costs.length];
        dp[0]=cost[0];
        dp[1]=cost[0]+cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        System.out.println( dp[dp.length-1]);
    }
    @Test
    public void test(){
        String costs[]="10,1,15,1,1,20".split(",");

        int[] cost=new int[costs.length];

        for(int i=0;i<cost.length;i++){
            cost[i]=Integer.valueOf(costs[i]);
        }
        if(cost.length<=2){
            System.out.println(cost[0]);
            return;
        }
        int[] dp=new int[costs.length];
        dp[0]=0;
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        System.out.println( dp[dp.length-1]);
    }
}