package com.yize.leetcode;

import java.util.Arrays;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 */
public class L611 {
    public int triangleNumber(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int count=0;
        for(int c=len-1;c>=2;c--){
            int a=0;
            int b=c-1;
            while(a<b){
                if(nums[a]+nums[b]>nums[c]){
                    count+=b-a;
                    b--;
                }else{
                    a++;
                }
            }
        }
        return count;

    }
}
