package com.yize.leetcode;

import org.junit.Test;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 * 通过次数35,302提交次数70,245
 */
public class L153 {
    @Test
    public void test(){
        System.out.println(findMin(new int[]{2,1}));
    }

    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=(low+high)>>1;
            if(nums[mid]<nums[high]){//最小值在左侧
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return nums[low];
    }
}
