package com.yize.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L16 {
    @Test
    public void test(){
        System.out.println(threeSumClosest(new int[]{1,1,1,0},-100));
    }
    public int threeSumClosest(int[] nums, int target) {
        return method2(nums,target);
    }
    public int method2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }


    public int method1(int[] nums, int target) {
        int sum=Integer.MAX_VALUE;
        int miniGap=Integer.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    int val=nums[i]+nums[j]+nums[k];
                    if(Math.abs(val-target)<miniGap){
                        miniGap=Math.abs(val-target);
                        sum=val;
                        if(sum==target){
                            return sum;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
