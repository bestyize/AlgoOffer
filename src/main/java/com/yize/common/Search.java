package com.yize.common;

import org.junit.Test;

import java.util.Collections;

public class Search {
    @Test
    public void test(){
        int a[]=buildArray(100);
        int index=find(a,49);
        int ii=findTarget(a,49,0,a.length-1);
        System.out.println(index+"\t"+ii);
    }


    public int find(int a[],int target){
        int low=0,high=a.length-1;
        while (low<=high){
            int middle=(low+high)>>1;
            if(target==a[middle]){
                return middle;
            }
            if(a[middle]>target){
                low=middle+1;
            }
            if(a[middle]>target){
                high=middle-1;
            }
        }
        return -1;
    }

    public int findTarget(int a[],int target,int low,int high){
        if(low<=high){
            int mid=(low+high)>>1;
            if(a[mid]==target){
                return (low+high)>>1;
            }
            return a[mid]>target?findTarget(a,target,low,mid-1):findTarget(a,target,mid+1,high);
        }
        return -1;

    }

    public int[] buildArray(int len){
        int[] a=new int[len];
        for(int i=0;i<a.length;i++){
            a[i]=i;
        }
        //Collections.sort(a);
        return a;
    }

}
