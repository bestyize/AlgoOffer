package com.yize.algo.chapter07;

import org.junit.Test;

public class QuickSelect {
    @Test
    public void test(){
        int[] nums={3,5,1,6,7};
        if(nums.length%2==0){
            int k1=(nums.length+1)>>1;
            quickSelect(nums,k1);
            int a=nums[k1-1];
            int k2=(nums.length+1)>>1+1;
            quickSelect(nums,k2);
            int b=nums[k2-1];
            System.out.println((a+b)>>1);
        }else {
            int k=(nums.length+1)>>1;
            quickSelect(nums,k);
            System.out.println(nums[k-1]);
        }
    }

    public void quickSelect(int[] nums,int k){
        quickSelect(nums,0,nums.length-1,k);
    }


    public void quickSelect(int nums[],int left,int right,int k){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while(i<j){
                while(i<j&&nums[j]>=pivot){j--;}
                while(i<j&&nums[i]<=pivot){i++;}
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,left,i);
            if(k<=i){
                quickSelect(nums,left,i-1,k);
            }else {
                quickSelect(nums,i+1,right,k);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
