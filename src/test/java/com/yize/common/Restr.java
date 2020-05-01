package com.yize.common;

public class Restr {
    public static void main(String[] args) {
        System.out.println();
        char[] cs="www.people.com.cn".toCharArray();
        reversePart(cs);
        for (char c:cs){
            System.out.print(c+"");
        }

    }

    public static void reversePart(char[] cs){
        if(cs.length<2){
            return;
        }
        int quick=0,slow=0;

        while (quick<cs.length){
            int pointIndex=0;
            while (quick<cs.length&&cs[quick]!='.'){
                quick++;
                pointIndex=quick;
            }

            while (slow<quick){
               swap(cs,slow++,--quick);
            }
            slow=pointIndex+1;
            quick=slow;
        }
    }
    private static void swap(char[] cs,int i,int j){
        char c=cs[i];
        cs[i]=cs[j];
        cs[j]=c;
    }

}
