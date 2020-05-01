package com.yize.algo.chapter07;

public class QuickSort {
    public static void main(String[] args) {
        int[] arrays={4,2,6,8,2,3};
        quickSort(arrays);
        PrinterHelper.print(arrays);


    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left<right){
            int i=left,j=right;
            int pivot=array[left];
            while (i<j){
                while (i<j&&array[j]>=pivot){j--;}//先从右向左找到第一个小于pivot的值,必须要先从右往左
                while (i<j&&array[i]<=pivot){i++;}//然后从左向右找到第一个大于pivot的值
                if(i<j){
                    swap(array,i,j);//交换
                }
            }
            swap(array,left,i);
            quickSort(array,left,i-1);
            quickSort(array,i+1,right);
        }
    }

    private static void swap(int[] array,int i,int j){
        if(i>=array.length||j>=array.length||i<0||j<0){
            return;
        }
        int tem=array[i];
        array[i]=array[j];
        array[j]=tem;
    }
}
