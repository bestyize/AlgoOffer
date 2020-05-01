package com.yize.newcoder.bytedance;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 最长连续子序列
 */
public class T9 {
    @Test
    public void test(){
        int nums[]={1,4,5,6,2,3,4,5,6,7,9};
        maxArray(nums);

    }

    public void maxArray(int[] nums){
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int max=0;
        for(int i:nums){
            if(!set.contains(i-1)){
                int count=0;
                while(set.contains(i++)){
                    count++;
                }
                max=Math.max(max,count);
            }
        }
        System.out.println(max);
    }
}
