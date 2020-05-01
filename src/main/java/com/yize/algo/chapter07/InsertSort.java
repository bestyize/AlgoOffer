package com.yize.algo.chapter07;

public class InsertSort {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        insertSort(array);
        PrinterHelper.print(array);
    }
    public static void insertSort(int[] nums){
        int[] array=nums;
        for(int i=1;i<array.length;i++){
            int temp=array[i];
            int ptr=i;
            while (ptr>0&&array[ptr-1]>temp){
                array[ptr]=array[ptr-1];
                ptr--;
            }
            array[ptr]=temp;
        }
        PrinterHelper.print(array);
    }
}
