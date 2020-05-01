package com.yize.leetcode;

import org.junit.Test;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class L283 {
    @Test
    public void test(){
        int[] z={0,1,0,3,12};
        moveZeroes(z);
    }
    public void moveZeroes(int[] nums) {
        int ptr=0;
        for(int i=1;i<nums.length;i++){
            int j=i;
            while(j>ptr&&nums[j]!=0){
                int temp=nums[j];
                nums[j]=nums[j-1];
                nums[j-1]=temp;
                j--;
            }
            if(nums[ptr]!=0){
                ptr++;
            }

        }
    }
}
