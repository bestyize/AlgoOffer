package com.yize.offer;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class T34 {
    public int FirstNotRepeatingChar(String str) {
        int[] table=new int['z'-'A'+1];
        char[] cs=str.toCharArray();
        for(char c:cs){
            table[c-'A']++;
        }
        for(int i=0;i<cs.length;i++){
            if(table[cs[i]-'A']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={4,2,6,8,2,3};
        quickSort(nums,0,nums.length-1);
        for(int i:nums){
            System.out.print(i+"\t");
        }
        System.out.println();

    }
    private static void quickSort(int[] num,int left,int right){
        if (left<right){
            int i=left,j=right;
            int pivot=medium3(num,left,right);
            while(i<j){
                while(j>i&&num[j]>=pivot){j--;};//从右向左找到第一个大于枢纽元的数
                while(j>i&&num[i]<=pivot){i++;};//从左向右找到第一个小于枢纽元的数
                if(j>i){
                    swap(num,i,j);
                }
                //继续找下一个
            }
            swap(num,left,i);//枢纽元换到最中间
            quickSort(num,left,i-1);//左边都是比枢纽元小的
            quickSort(num,i+1,right);//右边都是比枢纽元大的
        }
    }

    private static int medium3(int[] num,int left,int right){
        int mid=(left+right)>>1;
        if(num[mid]<num[left]){
            swap(num,mid,left);
        }
        if(num[right]<num[left]){
            swap(num,left,right);
        }
        if(num[mid]>num[right]){
            swap(num,mid,right);
        }
        swap(num,left,mid);//枢纽元放到left位置，也就是中值
        return num[left];
    }

    private static void swap(int[] num,int x1,int x2){
        int temp=num[x1];
        num[x1]=num[x2];
        num[x2]=temp;
    }


}
