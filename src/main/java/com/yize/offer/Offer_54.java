package com.yize.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Offer_54 {
    HashMap<Character,Integer> map=new HashMap<Character, Integer>();
    ArrayList<Character> list=new ArrayList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){//如果包含这个键值，那么给他统计+1
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
        list.add(ch);//存储输入字符串
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c='#';
        for(char cc:list){//遍历输入字符串，看一下谁是第一个出现的，并且只出现一次
            if(map.get(cc)==1){
                c=cc;
                break;
            }
        }
        return c;
    }
}
