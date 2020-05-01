package com.yize.newcoder.tx;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
 *
 * 小Q从第一栋一直走到了最后一栋，小Q从来没有看到过这么多高楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
 *
 * 输入描述：
 *
 * 输入第一行将包含一个数字n,表示楼的栋数，接下来的一行将包含n个数字wi(1<=i<=n)，代表一栋楼的高度。
 * ————————————————
 * 版权声明：本文为CSDN博主「JLUspring」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/qq_37724465/article/details/104430619
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] height=in.nextLine().split(" ");
        int nums[]=new int[height.length];
        for (int i=0;i<height.length;i++){
            nums[i]=Integer.valueOf(height[i]);
        }
        helper(nums);
    }

    public static void helper(int[] height){
        int[]result=new int[height.length];
        int right[]=new int[height.length];
        int left[]=new int[height.length];
        Stack<Integer> leftStack=new Stack<>();
        Stack<Integer> rightStack=new Stack<>();
        //从左往右看
        for(int i=height.length-1;i>=0;i--){
            right[i]=rightStack.size();
            if(rightStack.isEmpty()){
                rightStack.push(height[i]);//右边第一个
            }else if(height[i]<rightStack.peek()){
                rightStack.push(height[i]);//如果比右边矮，就入栈，都能看到
            }else {
                while (rightStack.size()>0&&height[i]>=rightStack.peek()){
                    rightStack.pop();//如果突然有个高的，
                    // 那就把右边比这个矮的弹出。//保持单调栈
                }
                rightStack.push(height[i]);
            }
        }
        //从右往左看
        for(int i=0;i<height.length;i++){
            left[i]=leftStack.size();
            if(leftStack.isEmpty()){
                leftStack.push(height[i]);
            }else if(height[i]<leftStack.peek()){
                leftStack.push(height[i]);
            }else {
                while (leftStack.size()>0&&height[i]>=rightStack.peek()){
                    leftStack.pop();//维护单调栈
                }
                rightStack.push(height[i]);
            }
        }

        for (int i=0;i<result.length;i++){
            result[i]=left[i]+right[i]+1;
        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
