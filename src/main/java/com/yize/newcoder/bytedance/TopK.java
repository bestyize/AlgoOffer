package com.yize.newcoder.bytedance;

import org.junit.Test;

public class TopK {
    @Test
    public void test(){
        int nums[]={3,4,1,6,9};
        int k=2;
        getKthGreater(nums,0,nums.length-1,k);
        System.out.println(nums[k-1]);
    }

    public void getKthGreater(int[] nums,int left,int right,int k){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while(i<j){
                while (i<j&&nums[j]>=pivot){
                    j--;
                }
                while (i<j&&nums[i]<=pivot){
                    i++;
                }
                swap(nums,i,j);
            }
            if(i>=k){
                getKthGreater(nums,left,i-1,k);
            }else {
                getKthGreater(nums,i+1,right,k);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
