package com.yize.leetcode;

import java.util.Stack;

/**
 * 581. 最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */
public class L581 {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> leftStack=new Stack<>();
        int left=nums.length-1;
        for (int i=0;i<nums.length;i++){
            while (leftStack.isEmpty()==false&&nums[i]<nums[leftStack.peek()]){
                left=Math.min(leftStack.pop(),left);
            }
            leftStack.push(i);
        }
        Stack<Integer> rightStack=new Stack<>();
        int right=0;
        for (int i=nums.length-1;i>=0;i--){
            while (rightStack.isEmpty()==false&&nums[i]>nums[rightStack.peek()]){
                right=Math.max(right,rightStack.pop());
            }
            rightStack.push(i);
        }
        return left<right?right-left+1:0;
    }
}
