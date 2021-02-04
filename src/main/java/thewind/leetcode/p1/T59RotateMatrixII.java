package thewind.leetcode.p1;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 通过次数58,191提交次数74,130
 */
public class T59RotateMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int count=0;
        int total=n*n;
        int layer=0;
        while (count<=total){

            for (int i=layer;i<n-1-layer&&count<total;i++){
                count++;
                matrix[layer][i]=count;
            }

            for (int i=layer+1;i<n-1-layer&&count<total;i++){
                count++;
                matrix[i][n-1-layer]=count;
            }

            for (int i=n-2-layer;i>=layer&&count<total;i--){
                count++;
                matrix[n-1-layer][i]=count;
            }

            for (int i=n-2-layer;i>layer&&count<total;i--){
                count++;
                matrix[i][layer]=count;
            }
            layer++;
        }
        return matrix;
    }
}
