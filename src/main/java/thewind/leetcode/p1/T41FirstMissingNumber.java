package thewind.leetcode.p1;

import org.junit.Test;

/**
 * 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 *
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 300
 * -231 <= nums[i] <= 231 - 1
 */
public class T41FirstMissingNumber {

    @Test
    public void test(){
        int nums[]={7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }

    /**
     * 思路，把数值x放到位置x-1处
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i=0;i<nums.length;i++){
            int curr=i;
            while (curr<nums.length&&nums[curr]>0&&nums[curr]<nums.length&&nums[curr]!=nums[nums[curr]-1]){
                swap(nums,curr,nums[curr]-1);
            }
        }
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public void swap(int[] nums,int p1,int p2){
        int temp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }
}
