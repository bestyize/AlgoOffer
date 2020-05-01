package com.yize.newcoder.bytedance;

import org.junit.Test;

// 有序数组找到第一个大于等于key的数字
public class T18 {
    @Test
    public void test(){
        int nums[]={1,4,5,7,8,9,23,56,77,99};
        System.out.println(findTarget(nums,99));
    }

    public int findTarget(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while (left<right){
            if(nums[left]>=target){
                return nums[left];
            }
            int mid=(left+right)>>1;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }

        }
        return nums[left];
    }
}
