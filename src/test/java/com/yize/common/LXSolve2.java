package com.yize.common;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LXSolve2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int wealths[]=new int[n];
        int totalWealth=0;
        for (int i=0;i<wealths.length;i++){
            wealths[i]=in.nextInt();
            totalWealth+=wealths[i];
        }
        if(totalWealth==0){
            System.out.println(0);
            return;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>();

        for (int wealth:wealths){
            if(maxHeap.size()<m){
                maxHeap.offer(wealth);
            }else {
                if(wealth>maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(wealth);
                }
            }
        }
        int topMWealth=0;
        while (maxHeap.isEmpty()==false){
            topMWealth+=maxHeap.poll();
        }
        System.out.println((topMWealth+0.0)/totalWealth);

    }
}
