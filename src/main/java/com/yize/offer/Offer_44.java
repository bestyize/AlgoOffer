package com.yize.offer;

import org.junit.Test;

import java.util.Stack;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Offer_44 {
    @Test
    public void test(){
        System.out.println(ReverseSentence1(" "));
    }

    public String ReverseSentence1(String str) {
        if(str==null||str.length()==0||str.equals(" ")){
            return str;
        }
        String ss[]=str.split(" ");
        StringBuilder sb=new StringBuilder();
        int ptr=ss.length-1;
        while (ptr>0){
            sb.append(ss[ptr--]+" ");
        }
        sb.append(ss[0]);
        return sb.toString();
    }

    public String ReverseSentence(String str) {
        Stack<String> stack=new Stack<>();
        int charStart=0;
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c==' '||i==str.length()-1){
                if(i==str.length()-1){
                    stack.push(str.substring(charStart));
                }else {
                    stack.push(str.substring(charStart,i));
                }
                charStart=i+1;
            }
        }
        StringBuilder sb=new StringBuilder();
        while (stack.size()>=2){
            sb.append(stack.pop()+" ");
        }
        sb.append(stack.pop());
        return sb.toString();

    }
}
