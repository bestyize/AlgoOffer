package com.yize.newcoder.mt;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 *  递归反转栈
 */
public class T1 {
    @Test
    public void test(){
        Stack<Integer> stack=new Stack<>();
        for (int i=1;i<=5;i++){
            stack.push(i);
        }
        System.out.println();
        reverseStack(stack);
        while (stack.size()>0){
            System.out.print(stack.pop());
        }
    }

    public void reverseStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int val=stack.pop();
        reverseStack(stack);
        stack.push(val);
    }





}
