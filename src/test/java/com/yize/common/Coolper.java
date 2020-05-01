package com.yize.common;

import com.yize.algo.chapter07.PrinterHelper;

import java.util.Scanner;

public class Coolper {
    public static void main(String[] args) {
        int[] nums={-100,2,5,9,5,2,4,10,23,54,27};
        mergeSort(nums,0,nums.length-1);
        PrinterHelper.print(nums);

    }

    private static void mergeSort(int []nums,int left,int right){
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int ptrLeft=left,ptrRight=mid+1;
        int currPtr=0;
        int []temp=new int[right-left+1];
        while (ptrLeft<=mid&&ptrRight<=right){
            if(nums[ptrLeft]<=nums[ptrRight]){
                temp[currPtr++]=nums[ptrLeft++];
            }else {
                temp[currPtr++]=nums[ptrRight++];
            }
        }
        while (ptrLeft<=mid){
            temp[currPtr++]=nums[ptrLeft++];
        }
        while (ptrRight<=right){
            temp[currPtr++]=nums[ptrRight++];
        }
        for (int i=left;i<=right;i++){
            nums[i]=temp[i-left];
        }

    }
}
