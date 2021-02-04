package thewind.leetcode.p1;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * 通过次数180,185提交次数392,795
 */
public class T16ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3){
            return -1;
        }
        Arrays.sort(nums);
        int closestNum=nums[0]+nums[1]+nums[2];
        for (int i=0;i<nums.length-2;i++){
            int left=i+1,right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(closestNum-target)){
                    closestNum=sum;
                }
                if(sum>target){
                    right--;
                }else if (sum<target){
                    left++;
                }else {
                    return sum;
                }
            }
        }
        return closestNum;
    }
}
