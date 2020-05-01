package com.yize.thread.practice;

import org.junit.Test;

//wait notify
//使用synchronized实现生产设消费者模型
/*
可以看出我们使用synchronized可以实现生产者/消费者模型，但是我们得要注意一点，
我们在这里使用的 notifyAll() 这个方法，为什么不能用 notify() ，也就是随便叫醒一个消费者呢？
答案是不可以，使用 notify() 是叫醒 LOCK 阻塞队列里面的任意一个线程，
假如此时我们的临界区域已经满了，此时唤醒的是一个生产者线程，就会导致死锁，
所以我们在这里采用的是 notifyAll() 这个方法，意思就是唤醒阻塞队列里面的全部线程，
这样某一个消费者就可以去取出临界区里面的产品，从而避免死锁的发生，
但是很显然，从上面打印的结果可以看出，顺序是无法保证的，想要保证顺序，可以试着使用可重入锁 ReentrantLock 来实现。

作者：虚心学习的小来子
链接：https://www.jianshu.com/p/d0c11dddafa4
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ProductConsumeTest {
    private static Integer count=0;
    private static final Integer FULL=10;
    private static String LOCK="lock";
    public static void main(String[] args) {
        ProductConsumeTest pcTest=new ProductConsumeTest();
        for(int i=1;i<=5;i++){
            new Thread(pcTest.new Producer()).start();
            new Thread(pcTest.new Consumer()).start();
        }
    }
    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count==FULL){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName()+"生产者正在生产，目前总共有"+count);
                    LOCK.notifyAll();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for (int i=0;i<10;i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (LOCK){
                    while (count==0){
                        try {
                            LOCK.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"消费者正在消费，目前总共有"+count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
