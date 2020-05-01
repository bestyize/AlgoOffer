package com.yize.newcoder.kuaishou;

/**
 * 41/43
 * [编程题]求x到y的最少计算次数
 * 时间限制：C/C++ 1秒，其他语言2秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 *
 * 给定两个-100到100的整数x和y,对x只能进行加1，减1，乘2操作，问最少对x进行几次操作能得到y？
 * 例如：
 * a=3,b=11: 可以通过3*2*2-1，3次操作得到11；
 * a=5,b=8：可以通过(5-1)*2，2次操作得到8；
 *
 *
 * 输入描述:
 * 输入以英文逗号分隔的两个数字，数字均在32位整数范围内。
 *
 * 输出描述:
 * 输出一个数字
 *
 * 输入例子1:
 * 3,11
 *
 * 输出例子1:
 * 3
 */
public class T4 {
    public static void main(String[] args) {
        int a=3;int b=9;
        int counter=0;
        if (a!=b){
            while (a*2<b){
                a*=2;
                counter++;
            }
            if(b-a>(a*2-b)){
                counter++;
                a*=2;
                counter+=(a-b);

            }else {
                counter+=(b-a);
            }

        }
        System.out.println(counter);
    }
}
