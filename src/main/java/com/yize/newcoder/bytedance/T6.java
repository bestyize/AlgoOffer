package com.yize.newcoder.bytedance;

import org.junit.Test;

//算法题二：给一数组，让你找一对满足i<j && a[i]<a[j]的i和j  (O(N)时间复杂度 O(1)空间复杂度)
public class T6 {
    @Test
    public void test(){
        find(new int[]{4,3,2,5,1});
    }
    public void find(int nums[]){
        int minPtr=0;
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=min){
                min=nums[i];
                minPtr=i;
            }else{
                System.out.println("i="+minPtr+"\tj="+i);
                break;
            }
        }
    }

}
