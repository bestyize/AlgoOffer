package com.yize.leetcode;

import org.junit.Test;

/**
 * 执行结果：
 * 通过
 * 显示详情
 * 执行用时 :
 * 3 ms
 * , 在所有 Java 提交中击败了
 * 98.43%
 * 的用户
 * 内存消耗 :
 * 47.4 MB
 * , 在所有 Java 提交中击败了
 * 14.56%
 * 的用户
 * 炫耀一下:
 */

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L4 {
    @Test
    public void test(){
        int[]a={1,3};
        int[]b={2};
        double s=findMedianSortedArrays(a,b);
        System.out.println(s);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n1=nums1.length,n2= nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);//确保前一个数组的长度小于等于第二个数组
        }
        int k=(n1+n2+1)/2;//两个数组的中位数，也就是两个数组中第K大或者K到K-1的数，这个K总是终点或者下半部分的起点
        int left=0;
        int right=n1;
        while (left<right){
            int m1=(right+left)/2;//数组1中left和right的中位数的位置，这里排除了m/2个数
            int m2=k-m1;//数组2中对应的位置（这里不是中位数）//这里排除了k-m1个数
            if(nums1[m1]<nums2[m2-1]){//如果当前数组1中的left和right之间的中位数小于排除的数组二中的中位数
                left=m1+1;//那么就说明两个数组的中位数在数组1的右边
            }else {
                right=m1;//否则的话可能在这里也可能在左边
            }
        }
        int m1=left;//如果是偶数，这是是中位数的后半部分，如果是奇数的话，那就是中位数位置
        int m2=k-left;//这是对应的中位数在数组2中的位置，也对应的是中位数的正中间或者中间靠后一位的索引
        int c1=Math.max(m1<=0?Integer.MIN_VALUE:nums1[m1-1],
                m2<=0?Integer.MIN_VALUE:nums2[m2-1]);
        if(((n1+n2)&1)!=0){
            return c1;
        }
        int c2=Math.min(m1>=n1?Integer.MAX_VALUE:nums1[m1],
                m2>=n2?Integer.MAX_VALUE:nums2[m2]);
        return (c1+c2)*0.5;
    }


    /**
     *时间复杂度O(m+n)，不满足题目要求
     * @param nums1
     * @param nums2
     * @return
     */
    public double method1(int[] nums1, int[] nums2) {
        int[] meger=new int[nums1.length+nums2.length];
        if(nums1.length<nums2.length){
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int ptr1=0,ptr2=0;
        int count=0;
        while (ptr1<nums1.length&&ptr2<nums2.length){
            if(nums1[ptr1]>nums2[ptr2]){
                meger[count]=nums2[ptr2];
                ptr2++;
            }else {
                meger[count]=nums1[ptr1];
                ptr1++;
            }
            count++;
        }
        while (ptr1<nums1.length){
            meger[count++]=nums1[ptr1++];
        }
        while (ptr2<nums2.length){
            meger[count++]=nums2[ptr2++];
        }

        int medium=meger.length>>1;
        double result=meger[medium];
        if(meger.length%2==0){
            medium=(meger.length-1)>>1;
            result=(meger[medium]+meger[medium+1])/2.0;
        }
        return result;
    }


}
