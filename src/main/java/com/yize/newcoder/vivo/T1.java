package com.yize.newcoder.vivo;

import org.junit.Test;

/**
 * 题目：正整数n,m(m>9), 找到最小正整数m使得m的各位（个十百千...）相乘等于n。比如n=36，m=49
 */
public class T1 {
    @Test
    public void test(){
        System.out.println(solution(100));
    }

    public static int solution(int n){
        StringBuilder s=new StringBuilder();
        for (int i=9;i>=1;i--){
            while (n%i==0&&n!=1){
               s.append(i);
               n/=i;
            }
        }
        return Integer.valueOf(s.reverse().toString());
    }
}
