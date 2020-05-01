package com.yize.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 316. 去除重复字母
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 */
public class L316 {
    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
    public String removeDuplicateLetters(String s) {
        int[] map=new int[128];
        char cs[]=s.toCharArray();
        for(int i=cs.length-1;i>=0;i--){
            if(map[cs[i]]==0){
                map[cs[i]]=i;
            }
        }
        int[] mark=new int[128];
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<cs.length;i++){
            char c=cs[i];
            if(mark[c]==0){
                while (!stack.isEmpty()&&stack.peek()>c&&map[stack.peek()]>i){
                    mark[stack.peek()]=0;
                    stack.pop();
                }
                stack.push(c);
                mark[c]=1;
            }
        }
        StringBuilder sb=new StringBuilder();
        while (stack.size()>0){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }


}
