package com.yize.thread.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列实现生产者消费者
 * 阻塞队列可以借助它本身的性质帮我们实现生产者/消费者模型，在某些情况下，访问队列会造成阻塞，队列被阻塞分为两种情况：
 *
 * 当队列满了的时候进行入队列操作
 * 当队列空了的时候进行出队列操作
 * 因此，当一个线程对已经满了的阻塞队列进行入队操作时会阻塞，除非有另外一个线程进行了出队操作，当一个线程对一个空的阻塞队列进行出队操作时也会阻塞，除非有另外一个线程进行了入队操作。所以阻塞队列本身就可以完成生产者/消费者模型。
 *
 * 作者：虚心学习的小来子
 * 链接：https://www.jianshu.com/p/d0c11dddafa4
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ProductConsumerBQ {
    private int count=0;
    private BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(6);

    public static void main(String[] args) {
        ProductConsumerBQ pcBQ=new ProductConsumerBQ();
        for(int i=0;i<5;i++){
            new Thread(pcBQ.new Producer()).start();
            new Thread(pcBQ.new Consumer()).start();
        }
    }
    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.put(1);
                    count++;
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.take();
                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
