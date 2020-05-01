package com.yize.leetcode;

import java.util.Stack;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 */
public class L402 {
    public static void main(String[] args) {
        System.out.println(removeKdigits("3512",2));
    }
//    public String removeKdigits(String num, int k) {
//        if (num == null || k >= num.length()) {
//            return "0";
//        }
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < num.length(); i++) {
//            char c = num.charAt(i);
//            //维护一个以本节点为栈顶的单调递增栈（即从左到右删掉前面元素大于后面元素的情况）
//            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
//                stack.pop();
//                k--;
//            }
//            stack.push(c);
//        }
//        //如果没有删完，继续删掉后面的一些元素
//        while (k > 0) {
//            stack.pop();
//            k--;
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        return sb.reverse().toString();
//    }
    public static String removeKdigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            //维护一个以本节点为栈顶的单调递减栈（即从左到右删掉前面元素小于后面元素的情况）
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        //如果没有删完，继续删掉后面的一些元素
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
