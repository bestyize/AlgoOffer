package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L179 {
    @Test
    public void test(){
        int[] nums=new int[]{10,2};
        System.out.println(largestNumber(nums));
    }


    public String largestNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strs[i]=nums[i]+"";
        }
        Arrays.sort(strs,(o1,o2)-> (o2+o1).compareTo(o1+o2));

        if(strs[0].startsWith("0")){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for (String s:strs){
            sb.append(s);
        }
        return sb.toString();
    }

}
