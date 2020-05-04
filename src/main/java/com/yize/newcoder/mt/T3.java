package com.yize.newcoder.mt;

import java.util.Scanner;

public class T3 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] strs=in.nextLine().split(" ");
        if(strs.length%2==0){
            System.out.println("error");
            return;
        }
        //检查合法性
        for(int i=0;i<strs.length;i++){
            if(i%2==0&&(!strs[i].equals("true")&&!strs[i].equals("false"))){
                System.out.println("error");
                return;
            }else if(i%2==1&&(!strs[i].equals("and")&&!strs[i].equals("or"))){
                System.out.println("error");
                return ;
            }
        }

        boolean[] dp=new boolean[(strs.length+1)>>>1];
        dp[0]=strs[0].equals("true");
        for(int i=1;i<dp.length;i++){
            boolean flag=false;
            if(strs[2*i-1].equals("or")){
                flag=dp[i-1]==true?true:strs[2*i].equals("true");
            }else{
                flag=dp[i-1]==false?false:strs[2*i].equals("true");
            }
            dp[i]=flag;
        }
        System.out.println(dp[dp.length-1]);
    }
}
