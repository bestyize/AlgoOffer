package com.yize.newcoder.bytedance;

import com.sun.xml.internal.ws.api.WSDLLocator;
import org.junit.Test;

/**
 * 作者：Joepirlo
 * 链接：https://www.nowcoder.com/discuss/371130?type=2&order=0&pos=5&page=1
 * 来源：牛客网
 *
 * 有一个整形数组，包含正数和负数，然后要求把数组内的所有负数移至正数的左边，且保证相对位置不变，要求时间复杂度为O(n), 空间复杂度为O(1)。例如，{10, -2, 5, 8, -4, 2, -3, 7, 12, -88, -23, 35}变化后是{-2, -4，-3, -88, -23,5, 8 ,10, 2, 7, 12, 35}。
 */
public class T1 {
    @Test
    public void test(){
        int [] arr=new int[]{10,-2,5,8,-4,2,-3};
        int quick=1,curr,prev=0;
        while (quick<arr.length){
            curr=quick;
            while (prev>=0&&arr[quick]<0&&arr[prev]>0){
                swap(arr,quick,prev);
                quick--;
                prev--;
            }
            prev=curr;
            quick=curr+1;
        }
        for(int i:arr){
            System.out.print(i+"\t");
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
