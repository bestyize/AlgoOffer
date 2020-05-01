package com.yize.algo.chapter07;

public class MergeSort {

    public static void main(String[] args) {
        int[] arrays={43,56,2,67,45,23,66,23,78,36,27};
        mergeSort(arrays);
        PrinterHelper.print(arrays);

    }

    public static void mergeSort(int[] array){
        int[] tempArray=new int[array.length];
        mergeSort(array,0,array.length-1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if(low<high){
            int mid=(low+high)>>1;
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int leftPtr=low,rightPtr=mid+1;

        int []tempArray=new int[high-low+1];
        int curPtr=0;
        while (leftPtr<=mid&&rightPtr<=high){
            if(array[leftPtr]>array[rightPtr]){
                tempArray[curPtr++]=array[rightPtr++];
            }else {
                tempArray[curPtr++]=array[leftPtr++];
            }
        }
        while (leftPtr<=mid){
            tempArray[curPtr++]=array[leftPtr++];
        }
        while (rightPtr<=high){
            tempArray[curPtr++]=array[rightPtr++];
        }
        for(int i=0;i<tempArray.length;i++){
            array[low++]=tempArray[i];
        }
    }


}
