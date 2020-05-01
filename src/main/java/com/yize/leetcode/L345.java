package com.yize.leetcode;

import org.junit.Test;

public class L345 {
    @Test
    public void test(){
        System.out.println(reverseVowels("hello"));
    }

    public String reverseVowels(String s) {
        char cs[]=s.toCharArray();
        quickSwap(cs,0,cs.length-1);
        return new String(cs);
    }

    public void quickSwap(char[] cs,int left,int right){
        while(left<right){
            while(left<right&&!suit(cs[right])){
                right--;
            }
            while(left<right&&!suit(cs[left])){
                left++;
            }
            if(left<right){
                swap(cs,left,right);
            }
            left++;
            right--;
        }
    }

    private boolean suit(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }

    private void swap(char[] cs,int i,int j){
        char temp=cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }
}
