package com.yize.newcoder.bytedance;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题目: 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手中没牌。根据桌上的牌堆顺序，输出原先手中牌堆的顺序数组。
 * 原创TheGatsby 最后发布于2019-09-17 23:08:57 阅读数 580  收藏
 * 展开
 * 面试题目: 一副从1到n的牌，每次从牌堆顶取一张放桌子上，再取一张放牌堆底，直到手中没牌。根据桌上的牌堆顺序，输出原先手中牌堆的顺序数组。
 * ————————————————
 * 版权声明：本文为CSDN博主「TheGatsby」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/EdwardTeach2/article/details/100943454
 */
public class T11 {
    @Test
    public void test(){
        int [] a=build(10);
        for (int n:a){
            System.out.print(n+" ");
        }
        System.out.println();
        int [] b=restore(a);
        for (int n:b){
            System.out.print(n+" ");
        }

    }
    //恢复扑克牌顺序
    public int[] restore(int[] nums){
        LinkedList<Integer> queue=new LinkedList<>();
        int result[]=new int[nums.length];
        int ptr=0;
        for (int i=nums.length-1;i>=0;i--){
            if(queue.size()>1){
                //手中牌数量大于1，那么把手中的牌的底部放到头部上来，然后再从桌子上拿一张牌过来
                queue.offerFirst(queue.pollLast());
            }
            //从桌子上拿一张牌放到手上
            queue.offerFirst(nums[i]);
        }
        while (queue.isEmpty()==false){
            result[ptr++]=queue.pollFirst();
        }
        return result;
    }



    public int[] build(int n){
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i=n;i>=1;i--){
            queue.offerFirst(i);
        }
        int result[]=new int[n];
        int ptr=0;
        while (queue.isEmpty()==false){
            result[ptr++]=queue.pollFirst();
            if(queue.isEmpty()==false){
                queue.offerLast(queue.pollFirst());
            }
        }
        return result;
    }
}
