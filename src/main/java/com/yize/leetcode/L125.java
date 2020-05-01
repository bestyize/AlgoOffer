package com.yize.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L125 {




    public boolean isPalindrome(String s) {
        char[] str=s.toUpperCase().toCharArray();
        int low=0,high=str.length-1;
        while (low<high){
           while (low<high&&!isVaild(str[low])){
               low++;
           }
           while (high>low&&!isVaild(str[high])){
                high--;
           }
           if(str[high--]!=str[low++]){
               return false;
           }
        }
        return true;
    }

    public boolean isVaild(char c){
        if((c>='0'&&c<='9')||(c>='A'&&c<='Z')){
            return true;
        }
        return false;
    }
}


