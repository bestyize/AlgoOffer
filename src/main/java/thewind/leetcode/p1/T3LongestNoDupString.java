package thewind.leetcode.p1;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * 通过次数794,539提交次数2,195,857
 */
public class T3LongestNoDupString {
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("abcabc"));
    }
    public int lengthOfLongestSubstring(String str) {
        int maxLen=0,offset=0;
        Map<Character,Integer> map=new HashMap<>();
        char[] cs=str.toCharArray();
        for (int i=0;i<cs.length;i++){
            if(map.containsKey(cs[i])){
                offset=Math.max(map.get(cs[i])+1,offset);
            }
            map.put(cs[i],i);
            maxLen=Math.max(maxLen,i-offset+1);
        }
        return maxLen;
    }
}
