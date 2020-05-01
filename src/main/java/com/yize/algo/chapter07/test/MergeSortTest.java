package com.yize.algo.chapter07.test;

import com.yize.algo.chapter07.PrinterHelper;

public class MergeSortTest {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        mergeSort(array);
        PrinterHelper.print(array);

    }

    private static void mergeSort(int[] array) {
        mergeSort(array,0,array.length-1);
    }

    private static void mergeSort(int[] array,int left,int right){
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int leftPtr=left,rightPtr=mid+1;
        int[] tempArray=new int[right-left+1];
        int curPtr=0;
        while (leftPtr<=mid&&rightPtr<=right){
            if(array[leftPtr]>array[rightPtr]){
                tempArray[curPtr++]=array[rightPtr++];
            }else {
                tempArray[curPtr++]=array[leftPtr++];
            }
        }
        while (leftPtr<=mid){
            tempArray[curPtr++]=array[leftPtr++];
        }
        while (rightPtr<=right){
            tempArray[curPtr++]=array[rightPtr++];
        }
        for(int i=0;i<tempArray.length;i++){
            array[left++]=tempArray[i];
        }
    }
}
