package com.yize.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L120 {
    @Test
    public void test(){
        List<Integer> l1=new ArrayList<>();
        l1.add(2);
        List<Integer> l2=new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3=new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4=new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        List<List<Integer>> lists=new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        System.out.println(minimumTotal(lists));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp=new int[triangle.size()][triangle.size()];
        int layer=dp.length-1;
        while(layer>=0){
            List<Integer> list=triangle.get(layer);
            for(int i=0;i<list.size();i++){
                if(layer==dp.length-1){
                    dp[layer][i]=list.get(i);
                }else{
                    dp[layer][i]=list.get(i)+Math.min(dp[layer+1][i],dp[layer+1][i+1]);
                }
            }
            layer--;
        }
        return dp[0][0];
    }
}
