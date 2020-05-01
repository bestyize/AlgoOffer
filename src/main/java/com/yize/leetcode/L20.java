package com.yize.leetcode;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class L20 {
    @Test
    public void test(){
        System.out.println(isValid("()[]{}"));
    }
    public boolean isValid(String s) {
        char cs[]=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='('||cs[i]=='{'||cs[i]=='['){
                stack.push(cs[i]);
            }else{
                if(cs[i]-stack.peek()!=1&&cs[i]-stack.peek()!=2){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public boolean isValid1(String s) {
        Stack<Character> stack=new Stack<Character>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()==false&&map.get(stack.peek())==c){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
