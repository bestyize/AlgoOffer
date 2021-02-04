package thewind.leetcode.p1;

import org.junit.Test;

public class T28StrStr {

    @Test
    public void test(){
        String str="";
        str.indexOf("as");
        System.out.println(strStr("a","a"));
    }

    public int strStr(String haystack, String needle) {
        if(haystack==null||needle==null||haystack.length()<needle.length()){
            return -1;
        }
        if(needle.length()==0){
            return 0;
        }
        int m=haystack.length(),n=needle.length();
        for (int i=0;i<=m-n;i++){
            for (int j=0;j<n;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                if(j==n-1){
                    return i;
                }
            }
        }
        return -1;
    }
}
