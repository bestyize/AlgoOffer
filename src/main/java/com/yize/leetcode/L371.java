package com.yize.leetcode;

import org.junit.Test;

/**
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 *
 * 示例 1:
 *
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 *
 * 输入: a = -2, b = 3
 * 输出: 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L371 {
    @Test
    public void test(){
        System.out.println(getSub(20,30));
    }
    public int getSub(int a, int b) {
        b=~b+1;//获得-b
        while (b != 0) {
            int temp=a^b;//无进位累加值
            int carry=(a&b)<<1;//进位值
            //a=无进位累加值 b=进位值
            a=temp;
            b=carry;
        }
        return a;
    }

    public int getSum(int a, int b) {
        int result=0;
        int mask=0;
        while(true){
            mask=mask==0?1:mask<<1;
            if((a&mask)!=0&&(b&mask)!=0){//两个都是1，必然进位
                result|=mask<<1;
            }else if(!(((a&mask)==0)&&((b&mask)==0))){//其中某一个为1
                if((result&mask)==0){//如果现在位是0，那么将现在位变成1
                    result|=mask;
                }else{//如果现在位是1，那么要将当前位置0，高位放置1
                    result&=~mask;//清除原来位
                    result|=mask<<1;//进一位
                }
            }
            if(mask==1<<31){
                break;
            }
        }
        return result;
    }

    public int getSum1(int a, int b) {
        int result=0;
        for(int i=0;i<32;i++){
            int mask=1<<i;
            if((a&mask)!=0&&(b&mask)!=0){//两个都是1，必然进位
                result|=mask<<1;
            }else if(!(((a&mask)==0)&&((b&mask)==0))){
                if((result&mask)==0){
                    result|=mask;
                }else{
                    result&=~mask;//清除原来位
                    result|=mask<<1;//进一位
                }
            }
        }
        return result;
    }
}
