package com.yize.offer;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Offer_51 {

    public static int[] multiply(int[] A) {
        //用到了动态规划
        int B[]=new int[A.length];
        int []left=new int[A.length];
        int []right=new int[A.length];
        left[0]=1;
        for(int i=1;i<A.length;i++){
            left[i]=left[i-1]*A[i-1];//左乘积数组
        }
        right[right.length-1]=1;
        for(int j=A.length-2;j>=0;j--){
            right[j]=right[j+1]*A[j+1];//右乘积数组
        }
        for(int i=0;i<A.length;i++){
            B[i]=left[i]*right[i];//合并数组
        }
        return B;

    }
}
