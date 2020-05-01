package com.yize.newcoder.bytedance;

import java.util.Arrays;

/**
 * 204. 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class T16 {
    public int countPrimes(int n) {
        boolean isPrim[]=new boolean[n];
        for(int i=0;i<n;i++){
            isPrim[i]=true;
        }

        for(int i=2;i*i<n;i++){
            if(isPrim[i]){
                for(int j=i*i;j<n;j+=i){
                    isPrim[j]=false;
                }
            }
        }

        int count=0;
        for(int i=2;i<isPrim.length;i++){
            if(isPrim[i]){
                count++;
            }
        }
        return count;
    }
}
