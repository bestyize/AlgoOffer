package com.yize.algo.chapter06;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TopKProblemUseHeap {
    @Test
    public void test(){
        int[] nums={1,5,7,2,9,12,87,32,56,92,4};
        int[] s=getTopKNumber(nums,nums.length);
        System.out.println(s);
        for (int i:s){
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    private int[] getTopKNumber(int[] nums,int k){
        PriorityQueue<Integer> queue=new PriorityQueue<Integer>(k);
        for(int i=0;i<nums.length;i++){
            if(queue.size()<k){
                queue.offer(nums[i]);
            }else {
                if(queue.peek()<nums[i]){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        int[] result=new int[queue.size()];
        int count=0;
        while (queue.isEmpty()==false){
            result[count++]=queue.poll();
        }

        return result;
    }
}
