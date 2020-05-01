package com.yize.common;

import org.junit.Test;

public class RE {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()()(())"));

    }


    public static int longestValidParentheses(String s) {
        char[] cs=s.toCharArray();
        int[] dp=new int[cs.length];
        int max=0;
        //分两种情况()()和((()))
        for(int i=1;i<cs.length;i++){
            if(cs[i]==')'){
                int pre=i-dp[i-1]-1;
                if(cs[i-1]=='('){
                    dp[i]=i>=2?dp[i-2]+2:2;
                }else if(pre>=0&&cs[pre]=='('){
                    dp[i]=(pre-1)>=0?dp[i-1]+2+dp[pre-1]:dp[i-1]+2;
                }
                max=Math.max(dp[i],max);
            }
        }
        return max;
    }
    @Test
    public void find(){
        int[] nums={5,4,3,2,1,3,5,7};
        int min=nums[0];
        int index=0;
        for (int i=1;i<nums.length;i++){
            if(nums[i]>min){
                System.out.println("i="+index+",j="+i);
                return;
            }else {
                min=nums[i];
                index=i;
            }
        }
        System.out.println("没有");
        return;
    }
    @Test
    public void finder(){
        int[] nums = {1,1,2,2,2,2,2,2,2,2,2};
        int target=2;

        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=(left+right)>>1;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                if(mid>0&&nums[mid-1]==target){
                    right=mid-1;
                }else {
                    System.out.println(mid);
                    return;
                }
            }
        }
        System.out.println("Not Found");

    }




}
