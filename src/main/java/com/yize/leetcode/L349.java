package com.yize.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        for(int n:nums1){
            set.add(n);
        }
        Set<Integer> s=new HashSet<>();
        for(int n:nums2){
            if(set.contains(n)){
                s.add(n);
            }
        }
        int result[]=new int[s.size()];
        int ptr=0;
        for (int i:s){
            result[ptr++]=i;
        }

        return result;
    }
}
