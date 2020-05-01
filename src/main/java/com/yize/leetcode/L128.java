package com.yize.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L128 {
    @Test
    public void test(){
        System.out.println(longestConsecutive(new int[]{100,4,100,1,3,2,5,7,101}));
    }

    /**
     * 上边的暴力破解有一个问题就是做了很多没必要的计算，因为我们要找最长的连续数字。所以如果是数组 54367，当我们遇到 5 的时候计算一遍 567。遇到 4 又计算一遍 4567。遇到 3 又计算一遍 34567。很明显从 3 开始才是我们想要的序列。
     *
     * 换句话讲，我们只考虑从序列最小的数开始即可。实现的话，当考虑 n 的时候，我们先看一看 n - 1 是否存在，如果不存在，那么从 n 开始就是我们需要考虑的序列了。否则的话，直接跳过。
     *
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-3-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int max=0;
        Set<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        for(int n:nums){
            if(!set.contains(n-1)){
                int count=0;
                while(set.contains(n)){
                    n++;
                    count++;
                }
                max=Math.max(max,count);
            }
        }
        return max;
    }

}
