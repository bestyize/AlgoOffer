package com.yize.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

public class L215 {
//    /**
//     * 堆解法
//     * @param nums
//     * @param k
//     * @return
//     */
//    public int findKthLargest(int[] nums, int k) {
//        if(k>nums.length||nums.length==0){
//            return -1;
//        }
//        PriorityQueue<Integer> queue=new PriorityQueue<>(k);
//        for(int i=0;i<nums.length;i++){
//            if(queue.size()<k){
//                queue.offer(nums[i]);
//            }else{
//                if(queue.peek().compareTo(nums[i])<=0){
//                    queue.poll();
//                    queue.offer(nums[i]);
//                }
//            }
//        }
//        return queue.poll();
//    }
    @Test
    public void test(){
        int[] nums={3,5,2,8,9};
        System.out.println(findKthLargest(nums,1));
    }

    /**
     * 快速选择
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k){
        quickSelect(nums,0,nums.length-1,k);
        return nums[nums.length-k];
    }

    private void quickSelect(int nums[],int left,int right,int k){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while (i<j){
                while (i<j&&nums[j]>=pivot){
                    j--;
                }
                while (i<j&&nums[i]<=pivot){
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            if(k<=i){
                quickSelect(nums,left,i-1,k);
            }else {
                quickSelect(nums,i+1,right,k);
            }
        }
    }
    private void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
