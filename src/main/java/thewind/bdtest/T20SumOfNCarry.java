package thewind.bdtest;

import org.junit.Test;

public class T20SumOfNCarry {
    @Test
    public void test(){
        System.out.println(add("999","1"));
    }

    private static String base="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String add(String num1,String num2){
        String result="";
        int carry=0;
        int ptr1=num1.length()-1,ptr2=num2.length()-1;

        while (ptr1>=0||ptr2>=0||carry!=0){
            if(ptr1>=0){
                carry+=base.indexOf(num1.charAt(ptr1));
                ptr1--;
            }
            if(ptr2>=0){
                carry+=base.indexOf(num2.charAt(ptr2));
                ptr2--;
            }
            result=base.charAt(carry%base.length())+result;
            carry/=base.length();
        }
        return result;
    }
}
