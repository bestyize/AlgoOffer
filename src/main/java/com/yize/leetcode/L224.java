package com.yize.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 说明：
 *
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L224 {
    @Test
    public void test(){
        System.out.println(calculate("(5-(1+(5)))"));
    }

    public int calculate(String str){
        str=str.replaceAll(" ","");
        if(str==null||str.length()==0){
            return 0;
        }
        str="("+str+")";
        Stack<String> stack=new Stack<>();
        int result=0;
        for (char c:str.toCharArray()){
            if(c==')'){
                result=0;
                String temp="";
                String ct;
                while ((ct=stack.pop()).equals("(")==false){
                    temp=(ct)+temp;
                }
                if(stack.isEmpty()==false&&temp.length()==1){
                    stack.pop();
                    stack.push(temp);
                    continue;
                }else if(stack.isEmpty()==false&&temp.length()==0){
                    stack.pop();
                    continue;
                }
                Queue<Character> queue=new LinkedList<>();
                if(temp.startsWith("-")){
                    queue.offer('-');
                }else {
                    queue.offer('+');
                }
                for (char cc:temp.toCharArray()){
                    if(cc=='+'||cc=='-'){
                        queue.offer(cc);
                    }
                }

                String nums[]=temp.replaceAll("\\+","-").split("-");
                int cur=0;
                while (cur<nums.length){
                    if(queue.poll()=='+'){
                        result=result+Integer.valueOf(nums[cur++]);
                    }else {
                        result =result-Integer.valueOf(nums[cur++]);
                    }
                }
                if(result<0&&stack.isEmpty()==false){
                    if(stack.peek().equals("-")){
                        stack.pop();
                        stack.push("+"+String.valueOf(-result));
                    }else if(stack.peek().equals("+")){
                        stack.pop();
                        stack.push(String.valueOf(result));
                    }
                }else {
                    stack.push(String.valueOf(result));
                }


            }else {
                stack.push(c+"");
            }
        }
        return result;
    }


}
