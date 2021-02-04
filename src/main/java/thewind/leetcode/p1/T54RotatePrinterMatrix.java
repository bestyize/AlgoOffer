package thewind.leetcode.p1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 通过次数99,419提交次数234,804
 */
public class T54RotatePrinterMatrix {

    @Test
    public void test(){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length<0){
            return list;
        }
        int layer=0;
        int m=matrix.length;
        int n=matrix[0].length;

        int count=0;
        int total=m*n;
        while (count<total){
            //从左到右
            for (int i=layer;i<n-layer&&count<total;i++){
                list.add(matrix[layer][i]);
                count++;
            }
            //从上到下
            for (int i=layer+1;i<m-layer&&count<total;i++){
                list.add(matrix[i][n-1-layer]);
                count++;
            }
            //从右到左
            for (int i=n-2-layer;i>=layer&&count<total;i--){
                list.add(matrix[m-1-layer][i]);
                count++;
            }
            //从下到上
            for (int i=m-2-layer;i>layer&&count<total;i--){
                list.add(matrix[i][layer]);
                count++;
            }
            layer++;
        }
        return list;
    }
}
