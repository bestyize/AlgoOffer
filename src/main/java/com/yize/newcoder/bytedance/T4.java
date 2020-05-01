package com.yize.newcoder.bytedance;

import org.junit.Test;

/**
 *手写快排
 */
public class T4 {
    @Test
    public void test(){
        int[] nums={3,5,1,6,2,9,2,24,54,24,32,6,4,87,32};
        quickSort(nums);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }

    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[]nums,int left,int right){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while(i<j){
                while(i<j&&nums[j]>=pivot){j--;}//从右向左找到第一个小于枢纽元的数
                while(i<j&&nums[i]<=pivot){i++;}//从左向右找到第一个大于枢纽元的数
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,left,i);//恢复枢纽元
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
