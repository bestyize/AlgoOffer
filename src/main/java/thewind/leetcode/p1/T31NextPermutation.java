package thewind.leetcode.p1;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5,1,2]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 */
public class T31NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length<2){
            return;
        }
        int low=nums.length-2;//从后向前找到第一个顺序对
        while (low>=0&&nums[low]>=nums[low+1]){
            low--;
        }
        if(low>=0){//从后向前找到第一个大于前面查找的顺序对第一个数的第一个数,最差的结果是顺序对的后一个数
            int high=nums.length-1;
            while (high>=0&&nums[high]<=nums[low]){
                high--;
            }
            swap(nums,low,high);
        }
        //然后把顺序对后面那个数以及后面的数反转。最后反转是因为之后的数都是顺序数
        low++;
        int high=nums.length-1;
        while (low<high){
            swap(nums,low,high);
            low++;
            high--;
        }
    }


    private void swap(int[] nums,int low,int high){
        int temp=nums[low];
        nums[low]=nums[high];
        nums[high]=temp;
    }
}
