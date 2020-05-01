package com.yize.newcoder.bytedance;

import com.yize.algo.chapter07.PrinterHelper;
import org.junit.Test;

import java.util.Arrays;

/**
 * 1.给一对无序数组，给一个target整数，找出数组中两个数字相加为target，并输出下标(不能用哈希)
 * https://www.nowcoder.com/discuss/366054?type=2&order=0&pos=12&page=1
 */
public class T2 {
    @Test
    public void test(){
        PrinterHelper.print(get(new int[]{1,4,2,9,8,7,3},10));

    }

    public int[] get(int[] arr,int target){
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==target){
                    return new int[]{arr[i],arr[j]};
                }
            }
        }
        return new int[]{-1,-1};
    }
}
