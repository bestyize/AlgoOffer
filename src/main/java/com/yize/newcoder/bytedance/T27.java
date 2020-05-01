package com.yize.newcoder.bytedance;

import java.util.Random;

//[0,99]范围内随机数不重复地放入长度为100的数组
public class T27 {
    public static void main(String[] args) {
        int[] nums=new int[10];
        for (int i=0;i<nums.length;i++){
            nums[i]=i;
        }
        Random ran=new Random();
        for (int i=0;i<nums.length;i++){
            int j=ran.nextInt(nums.length);
            swap(nums,i,j);
        }
        for (int i:nums){
            System.out.print(i+"\t");
        }
    }
    public static void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
