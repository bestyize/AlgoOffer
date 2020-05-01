package com.yize.newcoder.kuaishou;

import java.util.Scanner;

public class T2 {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();
        char sc[]=str.toCharArray();
        if(sc.length==1){
            System.out.println("1"+sc[0]);
            return;
        }
        int slow=0,quick=1;
        int counter=1;
        StringBuilder sb=new StringBuilder();
        while(slow<sc.length){
            while(quick<sc.length&&sc[quick]==sc[slow]){
                quick++;
                counter++;
            }
            sb.append(counter+""+sc[slow]);
            counter=1;
            slow=quick;
            quick++;
        }
        System.out.println(sb.toString());
    }
}
