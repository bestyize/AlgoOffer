package com.yize.newcoder.bytedance;

import org.junit.Test;

/**
 *
 */
public class T10 {
    @Test
    public void test(){
        int nums[]={1,4,5,6,2,3,4,5,8,6,9};
        maxArray(nums);

    }

    private void maxArray(int[] nums) {
        int slow=0,quick=1;
        int max=0;
        while(quick<nums.length){
            int temp=nums[slow];
            while(quick<nums.length&&(temp+1==nums[quick])){
                temp=nums[quick];
                quick++;
            }
            max=Math.max(quick-slow,max);
            slow=quick;
            quick++;
        }
        System.out.println(max);
    }
}
