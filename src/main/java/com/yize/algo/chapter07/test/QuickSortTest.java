package com.yize.algo.chapter07.test;

import com.yize.algo.chapter07.PrinterHelper;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        quickSort(array);
        PrinterHelper.print(array);
    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }
    private static void quickSort(int[] array,int left,int right) {
        if(left<right){
            int i=left,j=right;
            int base=array[left];
            while (i<j){
                while (i<j&&array[j]>=base){j--;}
                while (i<j&&array[i]<=base){i++;}
                if(i<j){
                    swap(array,i,j);
                }
            }
            swap(array,left,i);
            quickSort(array,left,i-1);
            quickSort(array,i+1,right);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
