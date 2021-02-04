package thewind.leetcode.p2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 *
 * 找到所有出现两次的元素。
 *
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * 示例：
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [2,3]
 * 通过次数29,169提交次数42,630
 */
public class T442FindDupElements {

    @Test
    public void test(){
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int len=nums.length;
        for (int i=0;i<len;i++){
            int num=Math.abs(nums[i]);
            if(nums[num-1]>0){
                nums[num-1]*=-1;//不改变原位置元素
            }else {
                list.add(num);
            }
        }
        return list;

    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
