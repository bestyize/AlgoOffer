package com.yize.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L239 {
    @Test
    public void test(){
        int[] res=maxSlidingWindow(new int[]{7,2,4},2);
        for (int i:res){
            System.out.println(i);
        }
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length<k||nums.length<1){
            return new int[0];
        }
        int[] result=new int[nums.length-k+1];
        int quick=k-1,slow=0;
        int ptr=0;
        while (quick<nums.length){
            result[ptr++]=findMax(nums,slow++,quick++);
        }
        return result;
    }

    private int findMax(int nums[],int start,int end){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }

    /**
     * 维护一个单调队列，从左到右递减，虽然有两个循环，但是每个元素最多被压入和弹出各一次，所以整体而言，复杂度为O(N)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length<2){
            return nums;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        int result[]=new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if(queue.peekFirst()+k<=i){//说明处于窗口左侧，应该弹出了
                queue.pollFirst();
            }
            if(i-k+1>=0){
                result[i-k+1]=nums[queue.peekFirst()];
            }
        }

        return result;
    }





}
