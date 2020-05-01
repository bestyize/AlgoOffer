package com.yize.common;

public class TTT {
    public static void main(String[] args) {
        int number=Integer.MIN_VALUE;
        System.out.println(getBitOfInteger(number));
        System.out.println(Integer.bitCount(number));
    }

    public static int getBitOfInteger(int num){
        int count=0;
        for(int i=0;i<=31;i++){
            if((num|(1<<i))==num){
                count++;
            }
        }
        return count;
    }
}
