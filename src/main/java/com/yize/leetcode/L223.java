package com.yize.leetcode;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 *
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 *
 *
 *
 * 示例:
 *
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2
 * 输出: 45
 * 说明: 假设矩形面积不会超出 int 的范围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-area
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return (C-A)*(D-B)-Math.max(0,Math.min(C,G)-Math.max(A,E))*Math.max(0,Math.min(D,H)-Math.max(B,F))+(G-E)*(H-F);
    }

}
