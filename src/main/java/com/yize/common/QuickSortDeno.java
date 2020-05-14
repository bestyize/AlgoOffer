package com.yize.common;

import org.junit.Test;

public class QuickSortDeno {
    @Test
    public void test(){
        int[] nums={1,4,5,2,-1,99,43,32,67,31,44,19,17,43};
        //quickSort(nums);
        mergeSort(nums);
        print(nums);
    }

    /**************************************************************/

    /*
     *快排
     * @param nums
     */
    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int left,int right){
        if(left<right){
            int i=left;
            int j=right;
            int privot=nums[left];
            while(i<j){
                while(i<j&&nums[j]>=privot){
                    j--;
                }
                while(i<j&&nums[i]<=privot){
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,left,i);//恢复枢纽元
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void print(int[] nums){
        for (int n:nums){
            System.out.print(n+"\t");
        }
        System.out.println();
    }

    /********************归并*******************/

    public void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }
    private void mergeSort(int nums[],int left,int right){
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int ptrLeft=left,ptrRight=mid+1;
        int [] temp=new int[right-left+1];
        int ptrCurr=0;
        while(ptrLeft<=mid&&ptrRight<=right){
            if(nums[ptrLeft]<=nums[ptrRight]){
                temp[ptrCurr++]=nums[ptrLeft++];
            }else {
                temp[ptrCurr++]=nums[ptrRight++];
            }
        }
        while(ptrLeft<=mid){
            temp[ptrCurr++]=nums[ptrLeft++];
        }
        while (ptrRight<=right){
            temp[ptrCurr++]=nums[ptrRight++];
        }
        for (int n:temp){
            nums[left++]=n;
        }
    }


}
