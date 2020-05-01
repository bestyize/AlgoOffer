package com.yize.common;

import java.util.PriorityQueue;

public class TopK {
    public static void main(String[] args) {
        int[] num={};
    }

    public static void getTopK(int []num,int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->o2.compareTo(o1));
        for (int i=0;i<num.length;i++){
            if(queue.size()<k){
                queue.offer(num[i]);
            }else{
                if(queue.peek()<num[i]){
                    queue.poll();
                    queue.offer(num[i]);
                }
            }
        }


    }
}
