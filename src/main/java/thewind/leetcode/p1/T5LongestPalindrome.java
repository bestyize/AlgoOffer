package thewind.leetcode.p1;

import org.junit.Test;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * 通过次数458,105提交次数1,397,925
 */
public class T5LongestPalindrome {

    @Test
    public void test(){
        System.out.println(longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if(s==null||s.isEmpty()){
            return "";
        }
        char[] cs=s.toCharArray();
        boolean[][] match=new boolean[cs.length][cs.length];
        int maxLen=0;
        int maxStart=0,maxEnd=0;
        for (int i=0;i<cs.length;i++){
            for (int j=0;j<i;j++){
                if(i-j<=2){
                    match[j][i]=cs[i]==cs[j];
                }else {
                    match[j][i]=(cs[i]==cs[j])&&match[j+1][i-1];
                }
                if(match[j][i]){
                    int len=i-j+1;
                    if(len>maxLen){
                        maxLen=len;
                        maxStart=j;
                        maxEnd=i;
                    }
                }
            }
        }
        return s.substring(maxStart,maxEnd+1);
    }
}
