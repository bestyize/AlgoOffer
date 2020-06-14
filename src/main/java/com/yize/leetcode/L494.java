package com.yize.leetcode;

public class L494 {
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums,0,S);
        return count;
    }
    private void dfs(int[] nums,int curr,int S){
        if(curr==nums.length){
            if(S==0){
                count++;
            }
            return;
        }
        dfs(nums,curr+1,S-nums[curr]);
        dfs(nums,curr+1,S+nums[curr]);
    }
}
