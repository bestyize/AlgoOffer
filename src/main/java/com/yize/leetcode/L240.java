package com.yize.leetcode;

import org.junit.Test;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L240 {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1}};
        System.out.println(searchMatrix(matrix, 1));
    }

    /**
     * 执行用时 :
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 89.09%
     * 的用户
     * 内存消耗 :
     * 42.4 MB
     * , 在所有 Java 提交中击败了
     * 64.62%
     * 的用户
     * 右上角搜索
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length - 1;
        while (left <= right && up <= down) {
            int cur = matrix[up][right];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                up++;
            } else {
                right--;
            }
        }
        return false;
    }

}
