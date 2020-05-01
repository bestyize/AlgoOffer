package com.yize.offer;

import org.junit.Test;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 复制
 * 1,2,3,4,5,6,7,0
 * 输出
 * 复制
 * 7
 */
public class Offer_35 {
    @Test
    public void test(){
        System.out.println(InversePairs(new int[]{3,2,5,6,7,1}));
    }

    private int count=0;
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return count%=1000000007;
    }

    private void mergeSort(int[] array,int left,int right){
        if(left<right){
            int mid=(right+left)>>1;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,left,mid,right);
        }

    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftPtr=left,rightPtr=mid+1;
        int temp[]=new int[right-left+1];
        int curPtr=0;
        while (leftPtr<=mid&&rightPtr<=right){
            if(array[leftPtr]<=array[rightPtr]){
                temp[curPtr++]=array[leftPtr++];
            }else {
                temp[curPtr++]=array[rightPtr++];
                count+=mid-leftPtr+1;
                count%=1000000007;
            }
        }
        while (leftPtr<=mid){
            temp[curPtr++]=array[leftPtr++];
        }
        while (rightPtr<=right){
            temp[curPtr++]=array[rightPtr++];
        }
        for(int i=0;i<temp.length;i++){
            array[left++]=temp[i];
        }
    }
}
