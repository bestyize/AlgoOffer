package com.yize.leetcode;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Enumeration;
import java.util.Stack;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L8 {
    @Test
    public void test(){
        String s="2147483648";
        int re=myAtoi1(s);
        System.out.println(re);
    }
    private boolean isNumber(char[] cs,int ptr){
        return ptr>=cs.length?false:(cs[ptr]>='0'&&cs[ptr]<='9');
    }

    public int myAtoi1(String str) {
        String numStr="";
        char[] numArr=str.toCharArray();
        boolean isPositive=true;
        int ptr=0;
        while(ptr<numArr.length){
            while (ptr<numArr.length&&numArr[ptr]==' '){
                ptr++;
            }
            if(ptr<numArr.length&&((numArr[ptr]=='-'||numArr[ptr]=='+')&&isNumber(numArr,ptr+1)||isNumber(numArr,ptr))){
                if(numArr[ptr]=='-'){
                    isPositive=false;
                    ptr++;
                }else if(numArr[ptr]=='+'){
                    ptr++;
                }
                while (ptr<numArr.length&&isNumber(numArr,ptr)){
                    numStr+=numArr[ptr++];
                }
                break;
            }else {
                return 0;
            }
        }
        if(numStr.length()==0){
            return 0;
        }
        char numm[]=numStr.toCharArray();
        int[] num=new int[numm.length];
        for(int i=0;i<numm.length;i++){
            if(isPositive){
                num[i]=numm[i]-0x30;
            }else {
                num[i]=0x30-numm[i];
            }

        }
        int result=0;
        for(int i=0;i<num.length;i++){
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&num[i]>7)
                    ||result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&num[i]<-8)){
                return isPositive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            result=result*10+num[i];

        }
        return result;

    }

    public String getNumStr(String s){
        if(s==null||s.length()==0){
            return null;
        }
        int indexOfFirstNum=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
                indexOfFirstNum=i;
                break;
            }
        }
        if(indexOfFirstNum==-1){
            return null;
        }
        String numsStr="";
        if(indexOfFirstNum==0){
            int index=indexOfFirstNum+1;
            StringBuilder sb=new StringBuilder();
            sb.append(s.charAt(indexOfFirstNum));
            while (index<s.length()&&(s.charAt(index)<='9'&&s.charAt(index)>='0')){
                sb.append(s.charAt(index));
                index++;
            }
            numsStr="+"+sb.toString();

        }else {
            if(s.charAt(indexOfFirstNum-1)=='+'||s.charAt(indexOfFirstNum-1)=='-'||s.charAt(indexOfFirstNum-1)==' '){
                int index=indexOfFirstNum-2;
                while (index>=0){
                    if(s.charAt(index)!=' '){
                        return null;
                    }
                    index--;
                }
                index=indexOfFirstNum+1;
                StringBuilder sb=new StringBuilder();
                sb.append(s.charAt(indexOfFirstNum));
                while (index<s.length()&&(s.charAt(index)<='9'&&s.charAt(index)>='0')){
                    sb.append(s.charAt(index));
                    index++;
                }
                if(s.charAt(indexOfFirstNum-1)=='-'){
                    numsStr="-"+sb.toString();
                }else {
                    numsStr="+"+sb.toString();
                }
            }else {
                return null;
            }
        }
        return numsStr;
    }

    public int myAtoi(String str) {
        str=getNumStr(str);
        if(str==null||str.equals("")){
            return 0;
        }
        char cc[]=str.toCharArray();
        int nums[]=new int[cc.length-1];


        for(int i=1;i<cc.length;i++){
            if(cc[0]=='-'){
                nums[i-1]=0x30-cc[i];
            }else {
                nums[i-1]=cc[i]-0x30;
            }

        }

        int result=0;
        for(int i=0;i<nums.length;i++){
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&nums[i]>7)){
                return Integer.MAX_VALUE;
            }
            if(result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&nums[i]<-8)){
                return Integer.MIN_VALUE;
            }
            result=result*10+nums[i];
        }
        return result;
    }






}
