package com.yize.newcoder.bytedance;

/**
 * 给定一个数组，将奇数排在左边，偶数排在右边
 */
public class T26 {
    public static void main(String[] args) {
        int nums[]={3,5,6,-2,4,5,-6,7,-9,0};
        reOrder4(nums);
        for (int n:nums){
            System.out.print(n+"\t");
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     * 利用快排思想，复杂度O(n)
     * @param nums
     */
    public static void reOrder(int[] nums){
        int left=0,right=nums.length-1;
        while(left<right){
            while (left<right&&(nums[left]&1)==1){left++;}//找到第一个偶数
            while(left<right&&(nums[right]&1)==0){right--;}//找到第一个奇数
            if(left<right){
                swap(nums,left,right);
            }
        }
    }



    /**
     * 遍历数组，遇到奇数就把他放到左边
     * @param nums
     */
    public static void reOrder2(int[] nums){
        int ptr=0;//指向准备好的位置
        for (int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }

    /**
     * 使数组左边为奇数，右边为偶数
     * @param nums
     */
    public static void reOrder3(int[] nums){
        int ptr=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]<0){
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }

    /**
     * 目的：将奇数排到前面，偶数排到后面，且维持相对位置不变
     * 冒泡，维持顺序不变，因为不需要真的排序，每个元素最多访问一次
     * 所以时间复杂度为O(N)
     * @param nums
     */
    public static void reOrder4(int[]nums){
        int ptr=0;
        for (int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                int curr=i;
                while(curr>ptr){
                    swap(nums,curr,--curr);
                }
                ptr++;
            }
        }
    }




}
