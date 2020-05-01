package com.yize.newcoder.bytedance;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长字串
 */
public class T19 {
    @Test
    public void test(){
        String str="abcabcdff";
        System.out.println(maxDoDupArray(str));
    }

    public String maxDoDupArray(String str){
        char cs[]=str.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int left=0,maxLen=0;
        int maxStart=0;
        for (int i=0;i<cs.length;i++){
            if(map.containsKey(cs[i])){
                left=Math.max(left,map.get(cs[i])+1);
            }
            map.put(cs[i],i);
            if(i-left+1>maxLen){
                maxStart=left;
                maxLen=i-left+1;
            }
        }
        System.out.println(maxLen);
        return str.substring(maxStart,maxStart+maxLen);

    }
}
