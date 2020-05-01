package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class L315 {
    @Test
    public void test(){
        int[] nums={5,2,6,1};
        System.out.println(countSmaller(nums));
    }

    int[] counts;
    public List<Integer> countSmaller(int[] nums) {
        counts=new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        for(int i=counts.length-2;i>=0;i--){
            if(counts[i]==0){
                counts[i]=counts[i+1];
            }
        }
        List<Integer> list=new ArrayList<>();
        for (int i:counts){
            list.add(i);
        }
        return list;
    }

    private void mergeSort(int[] nums,int left,int right){
        if(left<right){
            int mid=(left+right)>>1;
            mergeSort(nums,left,mid);
            mergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int ptrLeft=left,ptrRight=mid+1;
        int temp[]=new int[right-left+1];
        int curr=0;
        while (ptrLeft<=mid&&ptrRight<=right){
            if(nums[ptrLeft]>nums[ptrRight]){
                counts[curr+ptrLeft]=mid-ptrLeft+1;
                temp[curr++]=nums[ptrRight++];

            }else {
                temp[curr++]=nums[ptrLeft++];
            }
        }
        while (ptrLeft<=mid){
            temp[curr++]=nums[ptrLeft++];
        }
        while (ptrRight<=right){
            temp[curr++]=nums[ptrRight++];
        }
        for (int i=0;i<temp.length;i++){
            nums[left+i]=temp[i];
        }
    }
    class Solution {
        //归并
        //归并的过程中给counter数组赋值
        //将counter数组依次加进List
        //原数组不变，记录原数组的角标一直在变
        public int[] indexes;
        public int[] temp;
        public int[] counter;
        public List<Integer> countSmaller(int[] nums) {
            ArrayList<Integer> counts = new ArrayList<Integer>();
            if(nums.length==0){
                return counts;
            }
            indexes = new int[nums.length];
            temp = new int[nums.length];
            counter = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                indexes[i]=i;
                counter[i]=0;
            }
            mergeAndCountSmaller(nums,0,nums.length-1);
            for(int i=0;i<nums.length;i++){
                counts.add(counter[i]);
            }
            return counts;
        }
        private void mergeAndCountSmaller(int[] nums,int l,int r){
            if(l==r){
                return;
            }
            int mid=l+(r-l)/2;
            mergeAndCountSmaller(nums,l,mid);
            mergeAndCountSmaller(nums,mid+1,r);
            mergeTwoArrAndCountSmaller(nums,l,mid,r);
        }
        private void mergeTwoArrAndCountSmaller(int[] nums,int l,int mid,int r){
            int i=l,j=mid+1;
            //temp作为indexes新旧的temp
            for(int m=l;m<=r;m++){
                temp[m]=indexes[m];
            }
            for(int k=l;k<=r;k++){
                if(i<=mid&&j<=r){
                    if(nums[temp[i]]<=nums[temp[j]]){
                        indexes[k]=temp[i++];
                        counter[indexes[k]]+=j-mid-1;
                    }else{
                        indexes[k]=temp[j++];
                    }
                }else{
                    if(i<=mid){
                        indexes[k]=temp[i++];
                        counter[indexes[k]]+=r-mid;
                    }else if(j<=r){
                        indexes[k]=temp[j++];
                    }
                }
            }

        }
    }

}
