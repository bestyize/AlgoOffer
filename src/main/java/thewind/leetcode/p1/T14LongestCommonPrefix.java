package thewind.leetcode.p1;

import org.junit.Test;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 * 通过次数431,860提交次数1,104,632
 */
public class T14LongestCommonPrefix {

    @Test
    public void test(){
        String[] strs={"flower","flower","flower","flower"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        char[] cs=strs[0].toCharArray();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<cs.length;i++){
            for (int j=0;j<strs.length;j++){
                if(strs[j].length()<=i||strs[j]==null||strs[j].isEmpty()||strs[j].charAt(i)!=cs[i]){
                    return sb.toString();
                }
            }
            sb.append(cs[i]);
        }
        return sb.toString();
    }
}
