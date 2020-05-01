package com.yize.newcoder.bytedance;

/**
 * 字符串由字母和数字组成，找出其中最大数字
 */
public class T13 {
    public static void main(String[] args) {
        String str="abcefsk24567hhf34hf96976f";
        char[] cs=str.toCharArray();
        int numStart=0;
        int numEnd=0;
        int max=Integer.MIN_VALUE;
        while(numStart<cs.length&&numEnd<cs.length){
            while(numStart<cs.length&&!isNum(cs[numStart])){//找到第一个数字
                numStart++;
            }
            numEnd=numStart;//最后一个数字
            int num=0;
            while (numEnd<cs.length&&isNum(cs[numEnd])){
                num=10*num+(cs[numEnd]-'0');
                numEnd++;
            }
            numStart=numEnd;
            max=Math.max(max,num);
        }
        System.out.println(max);

    }

    private static boolean isNum(char c){
        return c>='0'&&c<='9';
    }
}
