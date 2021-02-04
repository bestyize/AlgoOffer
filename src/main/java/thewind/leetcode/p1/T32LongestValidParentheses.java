package thewind.leetcode.p1;

/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 */
public class T32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] cs=s.toCharArray();
        int[] dp=new int[s.length()];//dp[i]表示以i为结尾的最长有效括号长度
        int max=0;
        //只有两种情况()()和(())
        for (int i=1;i<cs.length;i++){
            if(cs[i]==')'){
                int pre=i-dp[i-1]-1;
                if(cs[i-1]=='('){
                    dp[i]=i>=2?dp[i-2]+2:2;
                }else if (pre>=0&&cs[pre]=='('){
                    dp[i]=(pre-1)>=0?dp[i-1]+2+dp[pre-1]:dp[i-1]+2;
                }
                max=Math.max(max,dp[i]);
            }
        }
        return max;

    }

}
