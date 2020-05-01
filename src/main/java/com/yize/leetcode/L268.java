package com.yize.leetcode;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * 通过次数52,744提交次数96,738
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L268 {
    public int missingNumber1(int[] nums) {
        int result=nums.length;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
            result^=i;
        }
        return result;
    }
    public int missingNumber(int[] nums) {
        int result=nums.length;
        for(int i=0;i<nums.length;i++){
            result=result^i^nums[i];
        }
        return result;
    }
}
