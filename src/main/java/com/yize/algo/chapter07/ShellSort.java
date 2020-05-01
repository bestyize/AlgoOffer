package com.yize.algo.chapter07;

public class ShellSort {
    public static void shellSort(int array[]){
        for(int gap=array.length>>1;gap>0;gap>>=1){
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
        PrinterHelper.print(array);
    }
}
