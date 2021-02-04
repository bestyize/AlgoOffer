package thewind.leetcode.p1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class T15ThreeNum {

    @Test
    public void test(){
        System.out.println(threeSum(new int[]{0,0,0,0,0,0}));
    }

    /**
     * 思路 ，先排序再过滤
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if(nums.length<3){
            return list;
        }
        Arrays.sort(nums);
        int low=0,high=nums.length-1;
        while (low<high){
            if(nums[low]>0||nums[high]<0){//表明不可能
                return list;
            }
            while (low>0&&low<high-1&&nums[low]==nums[low-1]){//过滤重复元素
                low++;
            }
            while (high<nums.length-1&&nums[high]==nums[high+1]){//过滤重复元素
                high--;
            }
            int left=low+1;
            int right=high;
            while (left<right){
                int sum=nums[low]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> item=new ArrayList<>();
                    item.add(nums[low]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    list.add(item);
                    while (left<right&&nums[left]==nums[left+1]){//过滤重复元素
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(sum>0){
                    right--;
                }else {
                    left++;
                }
            }
            low++;
        }
        return list;
    }
}
