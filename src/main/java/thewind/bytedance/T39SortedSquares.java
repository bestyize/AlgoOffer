package thewind.bytedance;

/**
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 */
public class T39SortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] r=new int[nums.length];
        int low=0,high=nums.length-1;
        int ptr=high;
        while (low<high){
            if(Math.abs(nums[low])>=Math.abs(nums[high])){
                r[ptr--]=nums[low]*nums[low];
                low++;
            }else {
                r[ptr++]=nums[high]*nums[high];
                high--;
            }
        }
        return r;
    }
}
