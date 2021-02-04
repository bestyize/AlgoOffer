package thewind.leetcode.p1;

import javax.xml.ws.spi.http.HttpHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 * 通过次数54,232提交次数161,793
 */
public class T30ConnectAllWord {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list=new ArrayList<>();
        if(s==null||words==null||s.length()==0||words.length==0){
            return list;
        }
        Map<String,Integer> wordsMap=new HashMap<>();
        int wordCnt=words.length;
        int wordLen=0;
        for (String word:words){
            wordLen=word.length();
            if(!wordsMap.containsKey(word)){
                wordsMap.put(word,1);
            }else {
                wordsMap.put(word,wordsMap.get(word)+1);
            }
        }
        int totalLen=wordLen*wordCnt;
        if(s.length()<totalLen){
            return list;
        }
        for (int i=0;i<s.length()-totalLen+1;i++){
            String wordsStr=s.substring(i,i+totalLen);
            Map<String,Integer> map=new HashMap<>();
            for (int j=0;j<totalLen;j+=wordLen){
                String w=wordsStr.substring(j,j+wordLen);
                if(!map.containsKey(w)){
                    map.put(w,1);
                }else {
                    map.put(w,map.get(w)+1);
                }
            }
            if(map.equals(wordsMap)){
                list.add(i);
            }
        }
        return list;
    }
}
