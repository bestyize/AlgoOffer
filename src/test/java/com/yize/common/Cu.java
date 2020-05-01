package com.yize.common;

import java.util.concurrent.ConcurrentHashMap;

public class Cu {
    public static void main(String[] args) {


    }

    public int findKthNumber(int[] nums,int k){
        quickSelect(nums,0,nums.length-1,k);
        return nums[k];
    }

    public void quickSelect(int[] nums,int left,int right,int k){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while(i<j){
                while(i<j&&nums[j]>=pivot){//从右到左找到第一个小于枢纽元的值
                    j--;
                }
                while(i<j&&nums[i]<=pivot){//从左到右找到第一个大于枢纽元的值
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,left,i);
            if(i<k){
                quickSelect(nums,left,i,k);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
