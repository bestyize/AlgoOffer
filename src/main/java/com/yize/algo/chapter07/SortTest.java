package com.yize.algo.chapter07;

public class SortTest {
    public static void main(String[] args) {
        int[] nums={43,56,2,67,45,23,66,23,78,36,27};
        PrinterHelper.print(nums);
        //BubbleSort.bubbleSort(nums);
        //InsertSort.insertSort(nums);
        //ShellSort.shellSort(nums);
        HeapSort.heapSort(nums);
    }
}
