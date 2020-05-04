package com.yize.leetcode;

import java.util.Random;

/**
 * 384. 打乱数组
 * 打乱一个没有重复元素的数组。
 *
 * 示例:
 *
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 *
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 *
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 * 通过次数18,458提交次数36,243
 */
public class L384 {
    private int[] backup;
    private int[] nums;
    public L384(int[] nums) {
        this.nums=nums;
        backup=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            backup[i]=nums[i];
        }

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i=0;i<backup.length;i++){
            nums[i]=backup[i];
        }
        return backup;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random ran=new Random();
        for(int i=0;i<nums.length;i++){
            int j=ran.nextInt(backup.length);
            swap(nums,i,j);
        }
        return nums;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
