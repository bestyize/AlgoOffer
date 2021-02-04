package thewind.leetcode.p2;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 通过次数134,780提交次数306,189
 */
public class T79SearchWord {
    public boolean exist(char[][] board, String word) {
        char[] cs=word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if(dfs(board,i,j,cs,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int i,int j,char[] cs,int curr){
        if(curr==cs.length){
            return true;
        }
        if(i<0||j<0||i>=board.length||j>=board[i].length||cs[curr]!=board[i][j]){
            return false;
        }
        char c=board[i][j];
        board[i][j]='*';//记忆化搜索，搜过的不再搜
        //搜索上下左右
        boolean find=dfs(board,i-1,j,cs,curr+1)
                ||dfs(board,i+1,j,cs,curr+1)
                ||dfs(board,i,j-1,cs,curr+1)
                ||dfs(board,i,j+1,cs,curr+1);
        board[i][j]=c;
        return find;
    }
}
