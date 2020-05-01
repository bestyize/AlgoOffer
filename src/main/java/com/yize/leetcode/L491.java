package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 */
public class L491 {

    @Test
    public void test(){
        int[] nums={4, 6, 7, 7};
        System.out.println(findSubsequences(nums));
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result=new HashSet<>();
        backTrack(result,new ArrayList<Integer>(),nums,0);
        return new ArrayList<>(result);
    }

    public void backTrack(Set<List<Integer>> result,List<Integer> path,int[] nums,int ptr){
        if(ptr>=nums.length){
            return;
        }
        if(path.size()>1){
            result.add(new ArrayList<>(path));
        }
        for(int i=ptr;i<nums.length;i++){
            if(path.size()==0||nums[i]>=path.get(path.size()-1)){
                path.add(nums[i]);
                backTrack(result,path,nums,ptr+1);
                path.remove(path.size()-1);
            }
        }
    }
}
