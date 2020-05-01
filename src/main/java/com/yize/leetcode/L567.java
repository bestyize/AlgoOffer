package com.yize.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 *
 * 示例1:
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *  
 *
 * 示例2:
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *  
 *
 * 注意：
 *
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L567 {
    @Test
    public void test(){
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion1(s1,s2));
    }

    /**
     * 执行用时 :
     * 45 ms
     * , 在所有 Java 提交中击败了
     * 41.36%
     * 的用户
     * 内存消耗 :
     * 41.5 MB
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion1(String s1, String s2) {
        char cs[]=s1.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for (char key:cs){
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        HashMap<Character,Integer> tempMap=new HashMap<>();
        for (int i=0;i<s1.length()-1;i++){
            char key=s2.charAt(i);
            if(tempMap.containsKey(key)){
                tempMap.put(key,tempMap.get(key)+1);
            }else {
                tempMap.put(key,1);
            }
        }
        for (int i=s1.length()-1;i<s2.length();i++){
            char key=s2.charAt(i);
            if(tempMap.containsKey(key)){
                tempMap.put(key,tempMap.get(key)+1);
            }else {
                tempMap.put(key,1);
            }
            if(map.equals(tempMap)){
                return true;
            }
            //去掉开始的字符在map中的记录
            char firstChar=s2.charAt(i-s1.length()+1);
            int firstValue=tempMap.get(firstChar);
            if(firstValue==1){
                tempMap.remove(firstChar);
            }else {
                tempMap.put(firstChar,firstValue-1);
            }
        }
        return false;
    }

    /**
     * 很慢
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        char cs[]=s1.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for (char key:cs){
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        for (int i=0;i<s2.length()-s1.length()+1;i++){
            HashMap<Character,Integer> tempMap=new HashMap<>();
            for (int j=i;j<i+s1.length();j++){
                char key=s2.charAt(j);
                if(tempMap.containsKey(key)){
                    tempMap.put(key,tempMap.get(key)+1);
                }else {
                    tempMap.put(key,1);
                }
            }
            if(map.equals(tempMap)){
                return true;
            }
        }
        return false;
    }
}
