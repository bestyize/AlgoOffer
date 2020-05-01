package com.yize.leetcode;

/**
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import com.google.protobuf.Enum;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class L228 {
    @Test
    public void test(){
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> list=new ArrayList<>();
        int start=0;
        for (int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]!=1){
                if(start!=i){
                    list.add(nums[start]+"->"+nums[i]);
                }else {
                    list.add(nums[start]+"");
                }
                start=i+1;
            }
        }
        if(start==nums.length-1){
            list.add(""+nums[start]);
        }else if(start<nums.length-1){
            list.add(nums[start]+"->"+nums[nums.length-1]);
        }
        return list;
    }
}
