package com.yize.algo.chapter07.test;

import com.yize.algo.chapter07.PrinterHelper;


public class InsertSort {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        insertSort(array);
        PrinterHelper.print(array);
    }

    private static void insertSort(int[] array){
        for (int i=1;i<array.length;i++){
            int currentVal=array[i];
            int ptr=i;
            while (ptr>0&&currentVal<array[ptr-1]){
                array[ptr]=array[ptr-1];
                ptr--;
            }
            array[ptr]=currentVal;
        }
    }
}
