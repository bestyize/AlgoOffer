package com.yize.offer;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CS {
    private static final Object LOCK=new Object();
    private static int productCount=0;
    private static int maxCount=10;
    private static List<String> products=new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1;i++){
            new Thread(new Productor()).start();
            new Thread(new Consumer()).start();
        }
        Thread.sleep(1000);
    }
    static class Productor implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<20;i++){
                synchronized (LOCK){
                    while (productCount==maxCount){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String productId=Thread.currentThread().getName()+"_"+i;
                    products.add(productId);//生产的产品编号
                    System.out.println("线程："+Thread.currentThread().getName()+"生产："+productId);
                    productCount++;
                    LOCK.notifyAll();
                }
            }
        }
    }
    static class Consumer implements Runnable{

        @Override
        public void run() {
            for (int i=0;i<20;i++){
                synchronized (LOCK){
                    while (productCount==0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String productId=products.remove(productCount-1);
                    System.out.println("线程："+Thread.currentThread().getName()+"消费："+productId);
                    productCount--;
                    LOCK.notifyAll();
                }
            }
        }
    }
}
