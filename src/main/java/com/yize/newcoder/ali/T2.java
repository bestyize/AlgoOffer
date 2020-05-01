package com.yize.newcoder.ali;

import org.junit.Test;

import static com.yize.algo.chapter07.PrinterHelper.print;

/**
 * 算法：给定一个数组，将数组里面的每一位向后移动k位
 */
public class T2 {
    @Test
    public void test(){
        int[] arr=new int[]{1,2,3,4,5,6};
        moveK(arr,2);
    }

    public void moveK(int[] arr,int k){
        int moveTo=arr.length-1;
        int moveFrom=moveTo-k;
        while (moveFrom>=0){
            arr[moveTo--]=arr[moveFrom--];
        }
        print(arr);
    }
}
