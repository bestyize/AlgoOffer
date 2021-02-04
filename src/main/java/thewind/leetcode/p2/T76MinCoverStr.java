package thewind.leetcode.p2;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 *
 *
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 *
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 */
public class T76MinCoverStr {
    public String minWindow(String s, String t) {
        int[] sMap=new int[128];
        int[] tMap=new int[128];
        char[] cs=s.toCharArray();
        char[] ct=t.toCharArray();
        int uniCount=0;
        for (char c:ct){
            tMap[c]++;
            if(tMap[c]==1){
                uniCount++;
            }
        }
        int leftWindow=0,rightWindow=0;
        int start=0,minLen=Integer.MAX_VALUE;
        int matchCount=0;
        while (rightWindow<cs.length){
            char c=cs[rightWindow];
            if(tMap[c]>0){
                sMap[c]++;
                if(sMap[c]==tMap[c]){
                    matchCount++;
                }
            }
            rightWindow++;
            while (uniCount==matchCount){
                if(rightWindow-leftWindow<minLen){
                    minLen=rightWindow-leftWindow;
                    start=leftWindow;
                }
                char cc=cs[leftWindow];
                if(tMap[cc]>0){
                    sMap[cc]--;
                    if(sMap[cc]<tMap[cc]){
                        matchCount--;
                    }

                }
                leftWindow++;
            }
        }

        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
