package com.yize.algo.chapter07.test;

import com.yize.algo.chapter07.PrinterHelper;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        bubbleSort(array);
        PrinterHelper.print(array);
    }
    private static void bubbleSort(int[] array) {
        for(int i=0;i<array.length;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
        }
    }
}
