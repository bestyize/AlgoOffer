package thewind.leetcode.p1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 *
 * 输入：s = "A", numRows = 1
 * 输出："A"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由英文字母（小写和大写）、',' 和 '.' 组成
 * 1 <= numRows <= 1000
 * 通过次数205,822提交次数417,445
 * 在真实的面试中遇到过这道题？
 */
public class T6ZConverter {
    @Test
    public void test(){
        System.out.println(convert("AB",1));
    }
    public String convert(String s, int numRows) {
        if(s==null||s.length()<2||numRows==1||s.length()<numRows){
            return s;
        }
        char cs[]=s.toCharArray();

        StringBuilder[] sbs= new StringBuilder[numRows];
        for (int i=0;i<sbs.length;i++){
            sbs[i]=new StringBuilder();
        }
        int currLayer=0;
        boolean turn=false;
        for (int i=0;i<cs.length;i++){
            if(!turn){
                sbs[currLayer++].append(cs[i]);
            }else {
                sbs[currLayer--].append(cs[i]);
            }
            if(currLayer==-1||currLayer==numRows){
                currLayer=currLayer==-1?1:numRows-2;
                turn=!turn;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (StringBuilder c:sbs){
            sb.append(c);
        }
        return sb.toString();
    }
}
