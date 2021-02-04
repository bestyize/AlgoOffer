package thewind.bytedance;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 通过次数406,771提交次数765,325
 */
public class T4MaxSubSum {
    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currMax=maxSum;
        for (int i=0;i< nums.length;i++){
            currMax=Math.max(currMax+nums[i],nums[i]);//包含当前位置的最大和
            maxSum=Math.max(maxSum,currMax);//
        }
        return maxSum;
    }
}
