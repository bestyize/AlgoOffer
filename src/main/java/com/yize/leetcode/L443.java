package com.yize.leetcode;

/**
 * 443. 压缩字符串
 * 给定一组字符，使用原地算法将其压缩。
 *
 * 压缩后的长度必须始终小于或等于原数组长度。
 *
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 *
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 */
public class L443 {
    public int compress(char[] chars) {
        int left=0,right=0;
        int count=0;
        int to=0;
        while(right<chars.length){
            while(right<chars.length&&chars[left]==chars[right]){
                right++;
                count++;
            }
            chars[to++]=chars[left];
            if(count>1){
                char[] num=String.valueOf(count).toCharArray();
                for(char c:num){
                    chars[to++]=c;
                }

            }
            left=right;
            count=0;
        }
        return to;
    }
}
