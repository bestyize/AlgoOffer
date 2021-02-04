package thewind.leetcode.p2;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 *
 * 示例 1：
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 *
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class T72MinDist {
    public int minDistance(String word1, String word2) {
        char[] cs1=word1.toCharArray();
        char[] cs2=word2.toCharArray();
        /**
         * dp[i][j]表示让cs1变成cs2所需要的最小步数
         */
        int[][] dp=new int[cs1.length+1][cs2.length+1];
        for (int i=0;i<cs1.length;i++){
            dp[i][0]=i;
        }
        for (int i=0;i<cs2.length;i++){
            dp[0][i]=i;
        }
        for (int i=1;i<=cs1.length;i++){
            for (int j=1;j<=cs2.length;j++){
                if(cs1[i-1]==cs2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[cs1.length][cs2.length];
    }
}
