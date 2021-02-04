package thewind.bytedance;

import org.junit.Test;

public class T20AddImplOf36 {

    @Test
    public void test(){
        System.out.println(add("9","1"));
    }

    private static String base="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String add(String num1,String num2){
        char[] cs1=num1.toCharArray();
        char[] cs2=num2.toCharArray();
        int m=Math.max(cs1.length,cs2.length);
        int addin=0;
        String result="";
        for (int i=0;i<m;i++){
            int sum=addin;
            if(i<cs1.length){
                char c=cs1[cs1.length-1-i];
                sum+=base.indexOf(c);
            }
            if(i<cs2.length){
                char c=cs2[cs2.length-1-i];
                sum+=base.indexOf(c);
            }
            result=base.charAt(sum%base.length())+result;
            addin=sum/base.length();
        }
        if(addin!=0){
            result =base.charAt(addin%base.length())+result;
        }
        return result;
    }
}
