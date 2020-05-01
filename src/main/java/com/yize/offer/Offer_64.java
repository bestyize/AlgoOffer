package com.yize.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Offer_64 {
    public static void main(String[] args) {
        int a[]={2,3,4,2,6,2,5,1};
        ArrayList<Integer> list=new Offer_64().method2(a,3);
        System.out.println(list);
    }

    public ArrayList<Integer> method1(int [] num, int size) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(num.length<size||size==0){
            return list;
        }
        int leftWindow=0;
        for(int i=0;i<=(num.length-size);i++){
            list.add(maxValue(num,i,i+size-1));
        }
        return list;
    }

    public int maxValue(int[] num,int leftWindow,int rightWindow){
        int max=num[leftWindow];
        for(int i=leftWindow+1;i<=rightWindow&&rightWindow<num.length;i++){
            if(max<num[i]){
                max=num[i];
            }
        }
        return max;
    }

    public ArrayList<Integer> method2(int [] num, int size){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(num.length<size||size==0){
            return list;
        }
        int leftWindow=0;
        int maxVal=num[leftWindow];
        for(int i=1;i<num.length&&(leftWindow+size)<=num.length;i++){
            if(i==leftWindow+size){//到达窗口结尾
                list.add(maxVal);
                leftWindow++;//窗口右移一位
                maxVal=num[leftWindow];//获取第一个值
                i=leftWindow-1;//for循环完自动+1，所以这样就可以了
            }else {
                if(maxVal<num[i]){
                    maxVal=num[i];
                }

            }
        }
        list.add(maxVal);
        return list;
    }



    public ArrayList<Integer> method3(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(q.isEmpty())
                q.add(i);
            else if(begin > q.peekFirst())
                q.pollFirst();

            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }

    public ArrayList<Integer> method4(int [] num, int size)
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int max = num[0];
        int index = 0;
        int length = num.length;
        if (length == 0 || size <= 0) return arrayList;
        if(size>length) return arrayList;
        for (int i = 1; i < size; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }
        arrayList.add(max);
        for (int i = size; i < length; i++) {
            if (index == (i - size)) {
                max = num[index + 1];
                index=index+1;
                for (int j = i - size + 1; j <= i; j++) {
                    if (num[j] > max) {
                        max = num[j];
                        index = j;
                    }
                }
                arrayList.add(max);
            } else {
                if (num[i] > max) {
                    max = num[i];
                    index = i;
                }
                arrayList.add(max);
            }
        }
        return arrayList;
    }

}
