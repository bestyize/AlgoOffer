package com.yize.newcoder.bytedance;

/**
 * ��ŵ������
 */
public class T8 {
    public static void main(String[] args) {
        hTower(31,'A','B','C');
    }

    public static void hTower(int n,char a,char b,char c){
        if(n==1){
            move(1,a,c);
        }else {
            hTower(n-1,a,c,b);
            move(n,a,c);
            hTower(n-1,b,a,c);
        }
    }

    public static void move(int disk,char from,char to){
        System.out.println("���ӣ�"+disk+"��"+from+"�ƶ���"+to);
    }

}
