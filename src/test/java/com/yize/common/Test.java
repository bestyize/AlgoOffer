package com.yize.common;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;

import static com.yize.newcoder.bytedance.T27.swap;

public class Test {
    public static void main1(String[] args) {
        String str1= new String("123");
        String str2="123";

        System.out.println(str1==str2);
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","321"));
    }

    public static String multiply(String num1, String num2) {
        if(num1==null||num2==null){
            return "";
        }
        int len1=num1.length();
        int len2=num2.length();
        int result[]=new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                result[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(i)-'0');
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=len1+len2-1;i>0;i--){
            result[i-1]+=result[i]/10;
            result[i]%=10;
            sb.append(result[i]);
            if(i==1&&result[0]!=0){
                sb.append(result[0]);
            }

        }
        
        return sb.reverse().toString();
    }

    public static void main2(String[] args) {
        HashMap mmp=new HashMap(100);
        mmp.put(1,2);
        mmp.get(1);
        mmp.containsKey(1);
        mmp.clone();
        Integer.hashCode(12);
        "".hashCode();
        Double.hashCode(12);
        Float.hashCode(22);
        Boolean.valueOf(true);

        System.out.println(tableSizeFor(100));


        SoftReference<String> srStr=new SoftReference<>("abc");
        srStr.clear();
        ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
        threadLocal.set(1);
        
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;//把小于最高位的填充掉
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }

    public void ttt(){

    }

    public void quickSort(int[] nums,int left,int right){
        if(left<right){
            int i=left,j=right;
            int pivot=nums[left];
            while (i<j){
                while (i<j&&nums[j]>=pivot){
                    j--;
                }
                while (i<j&&nums[i]<=pivot){
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,left,i);
            quickSort(nums,left,i-1);
            quickSort(nums,i+1,right);
        }
    }

}
