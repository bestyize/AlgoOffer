package com.yize.offer;

import org.junit.Test;

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意
 * 一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动
 * 一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径
 * 不能再进入该格子。
 * 例如
 * a    b   c   e
 * s    f   c   s
 * a    d   e   e
 * ​
 *    矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *    因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Offer_65 {
    @Test
    public void test(){
        char[] matrix="ABCESFCSADEE".toCharArray();
        System.out.println(hasPath(matrix,3,4,"ABCB".toCharArray()));
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        char realMatrix[][]=new char[rows][cols];
        for (int i=0;i<matrix.length;i++){
            int newRow=i/cols;
            int newCol=i%cols;
            realMatrix[newRow][newCol]=matrix[i];
        }
        for(int i=0;i<realMatrix.length;i++){
            for(int j=0;j<realMatrix[0].length;j++){
                if(realMatrix[i][j]==str[0]){
                    char item[]=new char[str.length];
                    if(backTrack(realMatrix,new char[str.length],str,0,i,j))
                    return true;
                }
            }
        }
        return false;

    }
    public boolean backTrack(char[][] matrix,char[] item,char[] str,int count,int i,int j){
        if(i<0||j<0||j>=matrix[0].length||i>=matrix.length||matrix[i][j]=='#'){
            return false;
        }
        item[count]=matrix[i][j];
        if(item[count]!=str[count]){
            return false;
        }
        if(count==item.length-1){
            return true;
        }
        char c=matrix[i][j];
        matrix[i][j]='#';
        boolean result=backTrack(matrix,item,str,count+1,i-1,j)
                ||backTrack(matrix,item,str,count+1,i+1,j)
                ||backTrack(matrix,item,str,count+1,i,j-1)
                ||backTrack(matrix,item,str,count+1,i,j+1);
        matrix[i][j]=c;
        return result;
    }

}
