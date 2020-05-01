package com.yize.newcoder.bytedance;
//反转byte
public class T21 {
    public static void main(String[] args) {
        int a=127;
        int r=0;
        for (int i=0;i<8;i++){
            if((a&(1<<i))!=0){
                r|=(1<<(8-i));
            }
        }
        System.out.println(r);

    }
}
