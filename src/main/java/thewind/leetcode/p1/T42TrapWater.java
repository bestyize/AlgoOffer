package thewind.leetcode.p1;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 * 通过次数187,065提交次数346,479
 */
public class T42TrapWater {
    /**
     * 思路，先找到最高点，再分别找左右最高点
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if(height.length<3){
            return 0;
        }
        int max=height[0];
        int maxPos=0;
        for (int i=0;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
                maxPos=i;
            }
        }
        int leftMax=height[0];
        int leftArea=0;
        for (int i=0;i<maxPos;i++){
            if(height[i]<leftMax){
                leftArea+=leftMax-height[i];
            }else {
                leftMax=height[i];
            }
        }

        int rightMax=height[height.length-1];
        int rightArea=0;
        for (int i=height.length-1;i>maxPos;i--){
            if(height[i]<rightMax){
                rightArea+=rightMax-height[i];
            }else {
                rightMax=height[i];
            }
        }
        return leftArea+rightArea;

    }
}
