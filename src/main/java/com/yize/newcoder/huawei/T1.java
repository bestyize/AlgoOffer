package com.yize.newcoder.huawei;

import org.junit.Test;

/**
 * 作者：Valpha
 * 链接：https://www.nowcoder.com/discuss/370336?type=2&order=0&pos=1&page=1
 * 来源：牛客网
 *
 * 手撕代码：输入一个字符串，输出最大回文字符串。（也是入门题目，leetcode上忘了是初级还是中级了，以前做过但是生疏了……用了挺长时间，但是没做全，有种情况没考虑到。XXXABAXX……这种写好了，但是XXABBAX……这种完全没考虑到。面试官觉得勉强过但是又不够好😂于是又给我出了一道题
 */
public class T1 {
    @Test
    public void test(){
        String str="babbad";
        System.out.println(maxRString(str));
    }

    public String maxRString(String s){
        boolean[][] dp=new boolean[s.length()][s.length()];
        char sc[]=s.toCharArray();
        int low=0,high=0;
        for (int i=0;i<sc.length;i++){
            for(int j=0;j<=i;j++){
                if(i-j<3){
                    dp[i][j]=(sc[i]==sc[j]);
                }else {
                    dp[i][j]=(sc[i]==sc[j])&&dp[i-1][j+1];
                }
                if(dp[i][j]){
                    if(i-j>high-low){
                        high=i;
                        low=j;
                    }
                }
            }
        }
        return s.substring(low,high+1);
    }
}
