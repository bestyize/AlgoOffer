package com.yize.newcoder.kuaishou;

/**
 * [编程题]阶乘末尾非零数字
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 32M，其他语言64M
 *
 * 输入N，求N！末尾的第一个非零数字。如6 ! = 720，因此6的阶乘末尾的非零位是2。
 *
 * 输入描述:
 * 仅一行，包含一个整数N（0<=N<=10,000,000）
 *
 * 输出描述:
 * 仅一行，包含一个整数，表示最右边的非零的值
 *
 * 输入例子1:
 * 6
 *
 * 输出例子1:
 * 2
 *
 * 例子说明1:
 * 6 ! = 720
 */
public class T5 {
    public static void main(String[] args) {
        int n=5;
        int last=0;
        for (int i=n;i>1;i--){
            int temp=n*(n-1);

        }
        System.out.println();
    }
}
