package com.yize.offer;

public class RoateString {
    public static void main(String[] args) {
        String str="i am who";
        char cs[]=str.toCharArray();
        reverse(cs,0,cs.length-1);
        int slow=0;
        int quick=0;
        while (quick<cs.length){
            while (quick<cs.length&&cs[quick]!=' '){
                quick++;
            }
            reverse(cs,slow,quick-1);
            slow=quick+1;
            quick=slow;
        }
        System.out.println(new String(cs));

    }

    public static void reverse(char[] cs,int i,int j){
        while (i<j){
            char temp=cs[i];
            cs[i]=cs[j];
            cs[j]=temp;
            i++;
            j--;
        }
    }
}
