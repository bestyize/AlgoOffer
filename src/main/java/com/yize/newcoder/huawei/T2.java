package com.yize.newcoder.huawei;


import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.yize.algo.chapter07.PrinterHelper.print;


/**
 * 有两个有序的整型数组a和b（没有重复元素），他们的长度分别为lenA和lenB，求出他们的共同元素。
 * 　　例如：a = 0,1,3,5,7,9,11；b = 2,3,4,7,11；
 * 　　它们的交集为{3，7，11}。
 */
public class T2 {
    @Test
    public void test(){
        int a[]={0,1,3,5,7,9,11};
        int b[]={2,3,4,7,11};
        print(getInject(a, b));
    }

    public int[] getInject(int[] a, int[] b){
        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i:a){
            map.put(i,0);
        }
        for (int i:b){
            if(map.containsKey(i)){
                list.add(i);
            }
        }
        int arr[]=new int[list.size()];
        for (int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
