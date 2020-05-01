package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L75 {
    @Test
    public void test(){
        int[] n=new int[]{2,0,2,1,1,0};
        sortColors(n);
        for (int i:n){
            System.out.print(i);
        }
    }
    public void sortColors(int[] nums) {
        method2(nums);
    }

    public void method2(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums,p0,curr);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums,p2,curr);
                // 交换第k个和第curr个元素
                // p2--
                p2--;
            } else{
                curr++;
            }
        }
    }
    public void swap(int[] nums,int x,int y){
        int temp=nums[x];
        nums[x]=nums[y];
        nums[y]=temp;
    }

    public void method1(int[] nums) {
        int red=0,white=0,blue=0;
        for(int i:nums){
            if(i==0){
                red++;
            }else if(i==1){
                white++;
            }else{
                blue++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i<red){
                nums[i]=0;
            }else if(i<red+white){
                nums[i]=1;
            }else{
                nums[i]=2;
            }
        }
    }
}
