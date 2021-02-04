package thewind.leetcode.p1;

import org.junit.Test;

public class T9IsPalindrome {
    @Test
    public void test(){
        System.out.println(isPalindrome(Integer.MAX_VALUE));
    }
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int backUp=x;
        int result=0;
        while (x!=0){
            result=result*10+x%10;
            x/=10;
        }
        return result==backUp;
    }
}
