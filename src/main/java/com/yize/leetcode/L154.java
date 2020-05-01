package com.yize.leetcode;

import org.junit.Test;

/**
 * 154. 寻找旋转排序数组中的最小值 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 注意数组中可能存在重复的元素。
 *
 * 示例 1：
 *
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 *
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 *
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
public class L154 {
    @Test
    public void test(){
        System.out.println(findMin(new int[]{}));
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 75.40%
     * 的用户
     * 内存消耗 :
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 39.68%
     * 的用户
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=(high+low)>>1;
            while (low<high&&nums[mid]==nums[low]&&nums[mid]==nums[high]){//排除两边都相等的情况
                low++;
                high--;
            }
            if(nums[low]==nums[mid]){//修正左边界
                low=mid;
            }
            if(nums[high]==nums[mid]){//修正右边界
                high=mid;
            }
            if(low==high){//如果low==high了，说明这段内数据相等，都是最小值
                return nums[low];
            }
            if(nums[mid]<=nums[high]){//判断旋转点在左边或者当前
                high=mid;
            }else {
                low=mid+1;//旋转点在右侧
            }

        }
        return nums.length==0?0:nums[low];
    }
}
