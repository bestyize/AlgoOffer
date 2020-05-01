package com.yize.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class L54 {
    @Test
    public void test(){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0){
            return list;
        }
        int m=matrix.length-1;
        int n=matrix[0].length-1;
        int count=(m+1)*(n+1);
        int layer=0;
        while (count>0){
            //从左到右
            for (int i=layer;i<=n-layer&&count>0;i++){
                list.add(matrix[layer][i]);
                count--;
            }
            //从上到下
            for (int i=layer+1;i<=m-layer&&count>0;i++){
                list.add(matrix[i][n-layer]);
                count--;
            }
            //从右到左
            for (int i=n-layer-1;i>=layer&&count>0;i--){
                list.add(matrix[m-layer][i]);
                count--;
            }
            //从下到上
            for (int i=m-layer-1;i>layer&&count>0;i--){
                list.add(matrix[i][layer]);
                count--;
            }
            layer++;//读完一层，继续下一层
        }
        return list;
    }
}
