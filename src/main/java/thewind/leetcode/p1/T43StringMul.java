package thewind.leetcode.p1;

import org.junit.Test;

/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class T43StringMul {

    @Test
    public void test(){
        System.out.println(multiply("0","99"));
    }

    /**
     *
     * 1 2 3
     * 4 5 6 7
     *
     * 0 0 0 0 0 0 0
     */

    public String multiply(String num1, String num2) {
        char[] cs1=num1.toCharArray();
        char[] cs2=num2.toCharArray();
        int m=cs1.length,n=cs2.length;
        int[] result=new int[m+n];
        for (int i=m-1;i>=0;i--){
            for (int j=n-1;j>=0;j--){
                int temp=mul(cs1[i],cs2[j])+result[i+j+1];
                result[i+j+1]=temp%10;
                result[i+j]+=temp/10;
            }
        }
        for (int i=result.length-1;i>0;i--){
            int temp=result[i];
            result[i]=temp%10;
            result[i-1]+=temp/10;
        }
        StringBuilder sb=new StringBuilder();
        int start=0;
        while (start<result.length-1&&result[start]==0){
            start++;
        }
        for (int i=start;i< result.length;i++){
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public int mul(char c1,char c2){
        return (c1-0x30)*(c2-0x30);
    }
}
