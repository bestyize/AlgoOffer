package com.yize.newcoder.bytedance;

import org.junit.Test;

public class PrintMatrixByClockOrder {
    @Test
    public void test(){
        /**
         * 1 2 3
         * 4 5 6
         * 7 8 9
         */
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        printMatrixByClockOrder(matrix);
    }
    public void printMatrixByClockOrder(int[][] matrix){
        if(matrix.length==0){
            return;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int layer=0;
        int count=m*n;
        while (count>0){
            //从左到右
            for (int i=layer;i<n-layer&&count>0;i++){
                System.out.print(matrix[layer][i]+"\t");
                count--;
            }
            //从上到下
            for (int i=layer+1;i<m-layer&&count>0;i++){
                System.out.print(matrix[i][n-1-layer]+"\t");
                count--;
            }
            //从右到左
            for (int i=n-1-layer-1;i>=layer&&count>0;i--){
                System.out.print(matrix[m-1-layer][i]+"\t");
                count--;
            }
            //从下到上
            for (int i=m-2-layer;i>layer&&count>0;i--){
                System.out.print(matrix[i][layer]+"\t");
                count--;
            }
            layer++;
        }
    }
}
