package thewind.bdtest;

public class T4MaxSubSum {
    public int maxSubArray(int[] nums) {
        int maxSum=0;
        int currMaxSum=maxSum;
        for (int i=0;i<nums.length;i++){
            currMaxSum=Math.max(nums[i], currMaxSum+nums[i]);
            maxSum=Math.max(maxSum,currMaxSum);
        }
        return maxSum;
    }
}
