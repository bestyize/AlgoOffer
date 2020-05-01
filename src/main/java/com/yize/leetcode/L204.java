package com.yize.leetcode;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class L204 {
    public int countPrimes(int n) {
        int count=0;
        for (int i=2;i<=n;i++){
            if (isS(i)){
                count++;
            }
        }
        return count;
    }

    private boolean isS(int n){
        int half=(int)Math.sqrt(n);
        for (int i=2;i<=half;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
