package com.yize.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 通过次数29,456提交次数62,236
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L205 {

    /**
     * 原地Map
     * @param s
     * @param t
     * @return
     */
//    public boolean isIsomorphic(String s, String t) {
//        char[] sMap=new char[128];
//        boolean[] tMap=new boolean[128];
//        for (int i=0;i<s.length();i++){
//            char cs=s.charAt(i);
//            char ct=t.charAt(i);
//            if(sMap[cs]!='\0'||tMap[ct]==true){
//                if(sMap[cs]!=ct){
//                    return false;
//                }
//            }else{
//                sMap[cs]=ct;
//                tMap[ct]=true;
//            }
//        }
//        return true;
//    }

    public boolean isIsomorphic(String s, String t) {
        char[] mapS = new char[128];
        boolean[] mapT = new boolean[128];
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            if (mapS[sArr[i]] != '\0' || mapT[tArr[i]] == true) {
                if (mapS[sArr[i]] != tArr[i])
                    return false;
            }
            else {
                mapS[sArr[i]] = tArr[i];//字符映射
                mapT[tArr[i]] = true;//被映射过
            }
        }
        return true;
    }

    public boolean isIsomorphic3(String s, String t) {
        for (int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i))!=t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //实现思想是相同字符第一次出现的位置是相同的
    public boolean isIsomorphic2(String s, String t) {
        Map<Character,Integer> csMap=new HashMap<>();
        Map<Character,Integer> ctMap=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char cs=s.charAt(i),ct=t.charAt(i);
            if(!csMap.containsKey(cs)){
                csMap.put(cs,i);
            }
            if(!ctMap.containsKey(ct)){
                ctMap.put(ct,i);
            }
            if(csMap.get(cs)!=ctMap.get(ct)){
                return false;
            }
        }
        return true;
    }

    /**
     * 实现思想是双向映射
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        return helper(t,s)&&helper(s,t);
    }
    public boolean helper(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        for (int i=0;i<s.length();i++){
            char cs=s.charAt(i);
            char ct=t.charAt(i);
            if(map.containsKey(cs)){
                if(map.get(cs)!=ct){
                    return false;
                }
            }else {
                map.put(cs,ct);
            }
        }
        return true;
    }
}
