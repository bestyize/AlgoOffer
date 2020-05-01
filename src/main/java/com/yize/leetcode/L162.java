package com.yize.leetcode;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 *
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * 说明:
 *
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L162 {
    /**
     * 要不是题目下边提示时间复杂度可以达到 log 级别，还真不敢往二分的方面想。因为二分法，我们一般用在有序数组上，那么这个题为什么可以用二分呢？
     *
     * 不管什么情况，之所以能用二分，是因为我们可以根据某个条件，直接抛弃一半的元素，从而使得时间复杂度降到 log 级别。
     *
     * 至于这道题，因为题目告诉我们可以返回数组中的任意一个峰顶。所以我们只要确定某一半至少存在一个峰顶，那么另一半就可以抛弃掉。
     *
     * 我们只需要把 nums[mid] 和 nums[mid + 1] 比较。
     *
     * 先考虑第一次二分的时候，start = 0，end = nums.length - 1。
     *
     * 如果 nums[mid] < nums[mid + 1]，此时在上升阶段，因为 nums[n] 看做负无穷，也就是最终一定会下降，所以 mid + 1 到 end 之间至少会存在一个峰顶，可以把左半部分抛弃。
     *
     * 如果 nums[mid] > nums[mid + 1]，此时在下降阶段，因为 nums[0] 看做负无穷，最初一定是上升阶段，所以 start 到 mid 之间至少会存在一个峰顶，可以把右半部分抛弃。
     *
     * 通过上边的切割，我们就保证了后续左边界一定是在上升，右边界一定是在下降，所以第二次、第三次... 的二分就和上边一个道理了。
     *
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/find-peak-element/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-39/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=(high+low)>>1;
            if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }else{
                high=mid;
            }

        }
        return low;
    }
}
