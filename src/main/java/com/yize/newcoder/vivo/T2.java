package com.yize.newcoder.vivo;

import org.junit.Test;

/**
 * 1、相当于计算数列 1，2，2，3，3，3，4，4，4，4，5……前n项的和
 */
public class T2 {
    @Test
    public void test(){
        System.out.println(solution(3));
    }

    public int solution(int n){
        int sum=0;
        for (int i=1;i<=n;i++){
            sum+=(i*i);
        }
        return sum;
    }
}
