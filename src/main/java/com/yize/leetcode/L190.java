package com.yize.leetcode;

/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class L190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result=0;
        for(int i=31;i>=0;i--){
            if((n&(1<<i))!=0){
                result|=(1<<(31-i));
            }
        }
        return result;
    }
}
