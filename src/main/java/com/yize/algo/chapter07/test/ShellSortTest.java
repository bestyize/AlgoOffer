package com.yize.algo.chapter07.test;

import com.yize.algo.chapter07.PrinterHelper;

public class ShellSortTest {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        shellSort(array);
        PrinterHelper.print(array);
    }

    private static void shellSort(int[] array){
        for(int gap=array.length/2;gap>0;gap/=2){
            for(int i=gap;i<array.length;i++){
                int temp=array[i];
                int ptr=i;
                while (ptr>=gap&&array[ptr-gap]>temp){
                    array[ptr]=array[ptr-gap];
                    ptr-=gap;
                }
                array[ptr]=temp;
            }
        }
    }
}
