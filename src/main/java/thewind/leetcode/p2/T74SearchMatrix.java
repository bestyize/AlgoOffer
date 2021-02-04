package thewind.leetcode.p2;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * 通过次数79,367提交次数198,622
 */
public class T74SearchMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int low=0,right=matrix[0].length-1;
        while (low<matrix.length&&right>=0){
            if(matrix[low][right]>target){
                right--;
            }else if(matrix[low][right]<target){
                low++;
            }else {
                return true;
            }
        }
        return false;
    }
}
