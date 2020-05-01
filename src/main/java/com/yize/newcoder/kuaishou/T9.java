package com.yize.newcoder.kuaishou;

import java.util.Scanner;

public class T9 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1[]=in.nextLine().split(" ");
        String s2[]=in.nextLine().split(" ");
        StringBuilder sb=new StringBuilder();
        int ptr2=0;
        for(int i=0;i<s1.length;i++){
            sb.append(s1[i]+" ");
            if(i%4==3&&ptr2<s2.length){
                sb.append(s2[ptr2++]+" ");
            }
        }
        while(ptr2<s2.length){
            sb.append(s2[ptr2++]+" ");
        }
        String r=sb.toString();
        System.out.println(r.substring(0,r.length()-1));
    }
}
