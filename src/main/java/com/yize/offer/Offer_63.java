package com.yize.offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Offer_63 {
    @Test
    public void test(){
        int[] ss=new int[]{5,2,3,4,1,6,7,0,8};
        for(int i=0;i<ss.length;i++){
            Insert(ss[i]);
            double med=GetMedian();
            System.out.println(med);
        }

    }

    int[] values=new int[10];
    int len=0;
    public void Insert(Integer num) {

        if(len==values.length-1){//扩容
            //values=Arrays.copyOf(values,len*2);
            int temp[]=values;
            values=new int[len*2];
            for(int i=0;i<len;i++){
                values[i]=temp[i];
            }
        }
        values[len]=num;
        for(int i=len;i>0;i--){
            if(values[i]<values[i-1]){
                int temp=values[i];
                values[i]=values[i-1];
                values[i-1]=temp;
            }
        }
        len++;

    }

    public Double GetMedian() {
        if(len%2==1){
            int medium=len>>1;
            return (double)values[medium];
        }
        //获取中位数
        int medium=len/2-1;
        return (double)((values[medium]+values[medium+1])/2.0);
    }
}
