package com.yize.newcoder.bytedance;

import org.junit.Test;

/**
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
 */
public class T12 {
    @Test
    public void test(){
        int[][]result=generateMatrix(3);
        for (int i=0;i<result.length;i++){
            for (int j=0;j<result[0].length;j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int layer=0;
        int count=1;
        int [][] matrix=new int[n][n];
        int eleCount=n*n;
        while (count<=eleCount){
            //从左到右
            for(int i=layer;i<n-layer&&count<=eleCount;i++){
                matrix[layer][i]=count;
                count++;
            }
            //上到下
            for (int i=layer+1;i<n-layer&&count<=eleCount;i++){
                matrix[i][n-1-layer]=count;
                count++;
            }
            //从右到左
            for (int i=n-1-layer-1;i>layer&&count<=eleCount;i--){
                matrix[n-1-layer][i]=count;
                count++;
            }
            //从下到上
            for (int i=n-layer-1;i>layer&&count<=eleCount;i--){
                matrix[i][layer]=count;
                count++;
            }
            layer++;//进入下一层
        }
        return matrix;
    }
}
