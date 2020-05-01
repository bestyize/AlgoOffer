package com.yize.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Offer_52 {

    public static boolean match(char[] str, char[] pattern) {
        if(str==null||pattern==null){
            return false;
        }
        return match(str,pattern,0,0);
    }
    public static boolean match(char[] str, char[] pattern,int ptrStr,int ptrPat) {
        //检验到底，字符串和匹配字符串需要匹配到底
        if(ptrStr==str.length&&ptrPat==pattern.length){
            return true;
        }
        //pattern先到尾，匹配失败
        if(ptrStr!=str.length&&ptrPat==pattern.length){
            return false;
        }
        //匹配字符串的下一个字符是*
        if(ptrPat+1<pattern.length&&pattern[ptrPat+1]=='*'){
            //当前pattern和当前str匹配(通配符.或者直接相同)
            if((ptrStr!=str.length&&pattern[ptrPat]==str[ptrStr])||(pattern[ptrPat]=='.'&&ptrStr!=str.length)){
                //模式后移2，视为x*匹配0个字符,也就是匹配0个
                return match(str,pattern,ptrStr,ptrPat+2)
                        //匹配多个，也就是匹配str的下一个字符
                        ||match(str,pattern,ptrStr+1,ptrPat);
            }else {
                //当前不匹配，但是因为下一个是*,所以当前的str直接匹配pattern的下2个，跳过*
                return match(str,pattern,ptrStr,ptrPat+2);
            }
        }else {
            //pattern的下一个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false，也就是单个匹配完
            if((ptrStr!=str.length&&pattern[ptrPat]==str[ptrStr])||((pattern[ptrPat]=='.'&&ptrStr!=str.length))){
                return match(str,pattern,ptrStr+1,ptrPat+1);
            }else {
                return false;
            }
        }


    }

}



