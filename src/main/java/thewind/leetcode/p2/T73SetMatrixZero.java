package thewind.leetcode.p2;

import org.junit.Test;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 * 进阶:
 *
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 */
public class T73SetMatrixZero {

    @Test
    public void test(){
        int[][] matrix={{1,2,0,4},{2,0,4,5},{3,4,5,6},{7,8,9,10}};
        printMatrix(matrix);
        setZeroes(matrix);
        System.out.println("*************");
        printMatrix(matrix);
    }

    public void setZeroes(int[][] matrix) {
        //先检查第0行和第0列是否需要置零
        boolean rowZero=false,colZero=false;
        for (int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                colZero=true;
                break;
            }
        }
        for (int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                rowZero=true;
                break;
            }
        }
        //再遍历矩阵，发现0时将矩阵的对应的0行0列位置标0
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //将0行0列中0开头的行列置零
        for (int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for (int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for (int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        if(rowZero){
            for (int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        if(colZero){
            for (int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }

    }

    private void printMatrix(int[][] matrix){
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
