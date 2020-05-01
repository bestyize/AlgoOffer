package com.yize.leetcode;

import org.junit.Test;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L130 {
    @Test
    public void test(){
        char[][] board=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
    }

    public void solve(char[][] board) {

        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if(i==0||j==0||i==board.length-1||j==board[0].length-1){
                    dfs(board,i,j,'-','O');
                }
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                dfs(board,i,j,'X','O');
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                dfs(board,i,j,'O','-');
            }
        }
    }

    public void dfs(char[][] board,int i,int j,char replace,char target){
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=target){
            return;
        }
        board[i][j]=replace;
        dfs(board,i+1,j,replace,target);
        dfs(board,i-1,j,replace,target);
        dfs(board,i,j+1,replace,target);
        dfs(board,i,j-1,replace,target);
    }

    private void show(char[][] board){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
