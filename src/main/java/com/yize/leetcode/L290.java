package com.yize.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class L290 {
    @Test
    public void test(){
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character,Integer> cmap=new HashMap<>();//记录元素出现的第一个位置
        char[] cp=pattern.toCharArray();
        int[] ccp=new int[pattern.length()];
        for(int i=0;i<cp.length;i++){
            if(!cmap.containsKey(cp[i])){
                cmap.put(cp[i],i);
            }
            ccp[i]=cmap.get(cp[i]);
        }
        String[] cs=str.split(" ");
        Map<String,Integer> smap=new HashMap<>();//记录元素出现的第一个位置
        for(int i=0;i<cs.length;i++){
            if(!smap.containsKey(cs[i])){
                smap.put(cs[i],i);
            }
            if(ccp[i]!=smap.get(cs[i])){
                return false;
            }

        }
        return true;
    }
    public boolean wordPattern1(String pattern, String str) {
        Map<Character,Integer> cmap=new HashMap<>();//记录元素出现的第一个位置
        char[] cp=pattern.toCharArray();
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<cp.length;i++){
            if(!cmap.containsKey(cp[i])){
                cmap.put(cp[i],i);
            }
            sb1.append(cmap.get(cp[i]));
        }
        String[] cs=str.split(" ");
        Map<String,Integer> smap=new HashMap<>();//记录元素出现的第一个位置
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<cs.length;i++){
            if(!smap.containsKey(cs[i])){
                smap.put(cs[i],i);
            }
            sb2.append(smap.get(cs[i]));
        }
        if(sb1.toString().equals(sb2.toString())){
            return true;
        }
        return false;
    }
}
