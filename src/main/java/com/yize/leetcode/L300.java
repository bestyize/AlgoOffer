package com.yize.leetcode;

import org.junit.Test;

/**
 * 300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class L300 {
    @Test
    public void test(){
        int nums[]={10,9,2,2,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int dp[]=new int[nums.length];
        int max=0;
        for (int i=0;i<nums.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }



    //原始版本的最大上升子序列,有三次循环,时间复杂度：O(n)空间复杂度:O(n)
    public int lengthOfLIS1(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int[] dp=new int[nums.length];//记录到每个位置的最长值
        for(int i=0;i<nums.length;i++){//每个位置至少自己是序列一部分，因此为1
            dp[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){//当前大于前一个，那么dp[i]=dp[i-1]+1;
                dp[i]=dp[i-1]+1;
            }
        }
        int max=0;
        for (int i=0;i<dp.length;i++){
            if(dp[i]>max){//遍历寻找最大值
                max=dp[i];
            }
        }
        return max;
    }
    //优化时间版本的最长上升子序列。时间复杂度：O(n)空间复杂度:O(n)
    //原始版本中，我们其实不需要三次循环
    public int lengthOfLIS2(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int[] dp=new int[nums.length];
        int max=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=nums[i]>nums[i-1]?dp[i-1]+1:1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    //其实我们也不需要O(n)的空间，我们只记录前一个状态即可
    //时间复杂度：O(n)空间复杂度:O(1)
    public int lengthOfLIS3(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int max=1;
        int prevLen=1;//记录前一个位置最大长度
        for(int i=1;i<nums.length;i++){
            int currLen=nums[i]>nums[i-1]?prevLen+1:1;
            prevLen=currLen;
            max=Math.max(max,currLen);
        }
        return max;
    }



}
