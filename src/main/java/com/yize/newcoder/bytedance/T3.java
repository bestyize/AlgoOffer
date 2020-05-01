package com.yize.newcoder.bytedance;

import org.junit.Test;

import java.util.Stack;

import static com.yize.algo.chapter07.PrinterHelper.print;

//算法：求最长递增子序列（原本以为是不连续的讲了半天。。面试官说是连续的，O（
public class T3 {
    @Test
    public void test(){
       print(maxArray(new int[]{1,2,4,-5,-6,4,8,9,2,-5,6}));
    }

    public int[] maxArray(int arr[]){
        int realStart=0;
        int ptr=0;
        int maxLen=0;
        while (ptr<arr.length){
            int start=ptr;
            while (ptr+1<arr.length&&arr[ptr]<arr[ptr+1]){
                ptr++;
            }
            if(ptr-start+1>maxLen){
                realStart=start;
                maxLen=ptr-start+1;
            }
            ptr++;
        }
        int result[] =new int[maxLen];
        System.arraycopy(arr,realStart,result,0,maxLen);
        return result;
    }
}
