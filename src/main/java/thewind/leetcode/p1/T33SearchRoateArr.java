package thewind.leetcode.p1;

import org.junit.Test;

/**
 * 33. 搜索旋转排序数组
 * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * nums 肯定会在某个点上旋转
 * -10^4 <= target <= 10^4
 */
public class T33SearchRoateArr {

    @Test
    public void test(){
        //int[] nums={4,5,6,7,0,1,2};
        int[] nums={0,1,2,4,5,6,7};
        System.out.println(search(nums,4));
    }

    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while (low<high){
            int mid=(low+high)>>1;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else if(nums[mid]<nums[high]){
                high=mid;
            }else {
                high--;
            }
        }
        //low是旋转点
        int p1=binarySearch(nums,0,low-1,target);
        if(p1!=-1){
            return p1;
        }
        return binarySearch(nums,low,nums.length-1,target);


    }

    public int binarySearch(int nums[],int low,int high,int target){
        while (low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]<target){
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }

}


