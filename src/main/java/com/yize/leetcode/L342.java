package com.yize.leetcode;

/**
 * 342. 4的幂
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 16
 * 输出: true
 * 示例 2:
 *
 * 输入: 5
 * 输出: false
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */
public class L342 {
    //方法1，检测奇数位，与mask位按位或，如果等于mask，说明为4的整次幂
    public boolean isPowerOfFour1(int num) {
        if(num<=0){
            return false;
        }
        for(int i=0;i<=30;i+=2){
            int mask=1<<i;
            if((num|mask)==mask){
                return true;
            }
        }
        return false;
    }

    /**
     * 方法2，直接构造一个数，0x55555555，和num按位与，看是不是num,在这之前，先检查一下是不是而的整次幂
     * @param num
     * @return
     */
    public boolean isPowerOfFour(int num){
        if(num<=0||(num&(num-1))!=0){
            return false;
        }
        return (0x55555555&num)==num;
    }
}
