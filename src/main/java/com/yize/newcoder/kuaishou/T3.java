package com.yize.newcoder.kuaishou;

import java.util.*;

public class T3 {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        String line=in.nextLine();
        if(!(line.charAt(0)=='+'||line.charAt(0)=='-')){
            line="+"+line;
        }

        char sc[]=line.toCharArray();
        Stack<Character> samStack=new Stack<>();
        for(char c:sc){
            if(c=='+'||c=='-'){
                samStack.push(c);
            }
        }
        String[] nums=line.replaceAll("-","+").split("\\+");
        int result=0;
        for(int i=nums.length-1;i>0;i--){
            if(samStack.pop()=='+'){
                result+=Integer.valueOf(nums[i]);
            }else{
                result-=Integer.valueOf(nums[i]);
            }
        }

        System.out.println(result);
    }
}
