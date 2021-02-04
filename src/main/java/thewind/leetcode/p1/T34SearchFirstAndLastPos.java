package thewind.leetcode.p1;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class T34SearchFirstAndLastPos {
    public int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]<target){
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                break;
            }
        }
        if(low<0||low> nums.length-1){
            return new int[]{-1,-1};
        }
        int gap=low;
        high=gap;
        low=0;
        int p1=-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]<target){
                    p1=mid;
                }else {
                    high--;
                }
            }else {
                if(nums[mid]<target&&nums[mid+1]==target){
                    p1=mid+1;
                    break;
                }
                low=mid;
            }
        }
        low=gap;
        int p2=-1;
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]==target){
                if(mid== nums.length-1||nums[mid+1]<target){
                    p2=mid;
                }else {
                    low++;
                }
            }else {
                if(nums[mid]>target&&nums[mid-1]==target){
                    p2=mid-1;
                    break;
                }
                low=mid;
            }
        }
        return new int[]{p1,p2};



    }
}
