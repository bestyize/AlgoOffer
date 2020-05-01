package com.yize.algo.chapter07;

public class HeapSort {
    public static void heapSort(int[] array){
        for(int i= (array.length>>1)-1;i>=0;i--){
            percDown(array,i,array.length-1);
        }
        PrinterHelper.print(array);
        int[] sortArray=new int[array.length];
        for(int i=sortArray.length-1;i>=0;i--){
            sortArray[sortArray.length-1-i]=deleteMin(array,i);
        }
        PrinterHelper.print(sortArray);

    }

    private static int deleteMin(int[] array,int currentLen){
        int min=array[0];
        array[0]=array[currentLen];
        percDown(array,0,currentLen);
        return min;
    }

    private static void percDown(int[] array,int hole,int currentLen){

        int temp=array[hole];
        while ((hole<<1)<currentLen){
            int nextHole=(hole<<1)+1;
            if(nextHole<currentLen&&array[nextHole]>array[nextHole+1]){
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
