package com.yize.algo.chapter07.test;

import com.yize.algo.chapter07.PrinterHelper;

public class HeapSortTest {
    public static void main(String[] args) {
        int[] array={43,56,2,67,45,23,66,23,78,36,27};
        heapSort(array);
        PrinterHelper.print(array);
    }

    private static void heapSort(int[] array){
        for(int i=array.length/2-1;i>=0;i--){//构建最小堆
            percDown(array,i,array.length);
        }
        int sortArray[]=new int[array.length];
        for(int i=sortArray.length-1;i>=0;i--){
            sortArray[sortArray.length-1-i]=deleteMin(array,i+1);
        }
        for(int i=0;i<sortArray.length;i++){
            array[i]=sortArray[i];
        }

    }

    private static int deleteMin(int[] array, int currentSize) {
        int min=array[0];
        array[0]=array[currentSize-1];
        percDown(array,0,currentSize);
        return min;
    }

    //下滤
    private static void percDown(int[] array,int hole,int currentSize){
        int temp=array[hole];
        while (hole*2+1<currentSize){
            int nextHole=hole*2+1;
            if(nextHole+1<currentSize&&array[nextHole]>array[nextHole+1]){
                nextHole++;
            }
            if(array[nextHole]<temp){
                array[hole]=array[nextHole];
            }else {
                break;
            }
            hole=nextHole;
        }
        array[hole]=temp;
    }

}
