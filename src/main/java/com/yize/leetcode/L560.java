package com.yize.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 通过次数16,970提交次数38,531
 */
public class L560 {
    @Test
    public void test(){
        System.out.println(subarraySum(new int[]{1,1,1},2));
    }

    public int subarraySum(int[] nums, int k) {
        int max=nums[0],min=nums[0];
        for(int i=0;i<nums.length;i++){
            max=max>nums[i]?max:nums[i];
            min=min<nums[i]?min:nums[i];
        }
        int sum=0,count=0;
        int[] map=new int[k];
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k){
                count++;
            }
            count+=map[sum-k];
            map[sum]++;
        }
        return count;
    }
//    public int subarraySum(int[] nums, int k) {
//        int sum=0,count=0;
//        Map<Integer,Integer> map=new HashMap<>();
//        for (int i=0;i<nums.length;i++){
//            sum+=nums[i];
//            if(sum==k){
//                count++;
//            }
//            if(map.containsKey(sum-k)){
//                count+=map.get(sum-k);
//            }
//            if(!map.containsKey(sum)){
//                map.put(sum,1);
//            }else {
//                map.put(sum,map.get(sum)+1);
//            }
//        }
//        return count;
//    }
//    public int subarraySum(int[] nums, int k) {
//        int slow=0,quick=0;
//        int tempK=k;
//        int count=0;
//        while(slow<nums.length){
//            if(quick==nums.length){
//                tempK=k;
//                quick=++slow;
//            }else if(tempK-nums[quick]==0){
//                count++;
//                tempK-=nums[quick++];
//            }else{
//                tempK-=nums[quick++];
//            }
//        }
//        return count;
//    }
}
