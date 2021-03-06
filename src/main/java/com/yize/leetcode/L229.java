package com.yize.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class L229 {
    //摩尔投票法，扩展
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lis=new ArrayList<Integer>();
        if(nums.length==0){
            return lis;
        }
        int A=nums[0];
        int B=nums[0];
        int countA=0;
        int countB=0;
        for(int num:nums){
            if(num==A){
                countA++;
                continue;
            }
            if(num==B){
                countB++;
                continue;
            }
            if(countA==0){
                A=num;
                countA=1;
                continue;
            }
            if(countB==0){
                B=num;
                countB=1;
                continue;
            }
            countA--;
            countB--;
        }
        countB=0;
        countA=0;
        for(int num:nums){
            if(num==A){
                countA++;
            }else if(num==B){
                countB++;
            }
        }

        if(countA>nums.length/3){
            lis.add(A);
        }
        if(countB>nums.length/3){
            lis.add(B);
        }
        return lis;
    }
}
