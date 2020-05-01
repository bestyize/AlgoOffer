package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *  
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L151 {
    @Test
    public void test(){
        System.out.println(reverseWords2("    "));
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 98.96%
     * 的用户
     * 内存消耗 :
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        StringBuilder sb=new StringBuilder();
        String[] str=s.split(" ");
        for (int i=str.length-1;i>=0;i--){
            if(str[i].length()>0){
                sb.append(str[i]).append(' ');
            }
        }
        return sb.length()==0?"":sb.toString().substring(0,sb.length()-1);
    }

    /**
     * 2-3ms
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int wordEnd=s.length()-1;
        int wordStart=s.length()-1;
        char str[]=s.toCharArray();
        while(wordStart>=0){
            //找到第一个非空格
            while(wordEnd>=0&&str[wordEnd]==' '){
                wordEnd--;
                wordStart=wordEnd;
            }
            //找到单词的前一个位置
            while(wordStart>=0&&str[wordStart]!=' '){
                wordStart--;
            }
            int temp=wordEnd;//记录单词的最后一个位置
            //找到下一个字母出现的地方
            wordEnd=wordStart;
            while (wordEnd>=0&&str[wordEnd]==' '){
                wordEnd--;
            }
            if(wordEnd>=0){
                sb.append(str,wordStart+1,temp-wordStart).append(' ');
            }else {
                sb.append(str,wordStart+1,temp-wordStart);
                break;
            }
            wordStart=wordEnd;
        }
        return sb.toString();
    }

    /**
     * 4ms
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        StringBuilder sb=new StringBuilder();
        int wordEnd=s.length()-1;
        int wordStart=s.length()-1;
        while(wordStart>=0){
            //找到第一个非空格
            while(wordEnd>=0&&s.charAt(wordEnd)==' '){
                wordEnd--;
                wordStart=wordEnd;
            }
            //找到单词的前一个位置
            while(wordStart>=0&&s.charAt(wordStart)!=' '){
                wordStart--;
            }
            int temp=wordEnd;//记录单词的最后一个位置
            //找到下一个字母出现的地方
            wordEnd=wordStart;
            while (wordEnd>=0&&s.charAt(wordEnd)==' '){
                wordEnd--;
            }
            if(wordEnd>=0){
                sb.append(s.substring(wordStart+1,temp+1)+" ");
            }else {
                sb.append(s.substring(wordStart+1,temp+1));
                break;
            }
            wordStart=wordEnd;
        }
        return sb.toString();
    }
}
