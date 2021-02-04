package thewind.leetcode.p1;

/**
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 1 4 7
 * 2 5 8
 * 3 6 9
 *
 * 7 4 1
 * 8 5 2
 * 9 8 7
 */

public class T48RotateImg {
    public void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for (int i=0;i<matrix.length;i++){
            int low=0,high=matrix[i].length-1;
            while (low<high){
                int temp=matrix[i][low];
                matrix[i][low]=matrix[i][high];
                matrix[i][high]=temp;
                low++;
                high--;
            }
        }

    }
}
