package com.yize.thread.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumerR {
    private int count=0;
    private final static int FULL=10;
    private Lock lock=new ReentrantLock();
    private Condition notEmptyCondition=lock.newCondition();
    private Condition notFullCondition=lock.newCondition();
    /**
     * 这里我们使用的是 Java 提供的 ReentrantLock 来实现生产者/消费者模型，
     * 与 synchronized 相比之下，一个 lock 我们可以生成多个 condition ，
     * 换句话说 synchronized 就像是只有一个 condition 的 ReentrantLock ，
     * 所以 后者比前者更加的灵活，但是也较为麻烦，因为每次都得手动地关闭锁，
     * 所以我们每次得尝试在 finally 里面关闭锁。
     *
     * 作者：虚心学习的小来子
     * 链接：https://www.jianshu.com/p/d0c11dddafa4
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        ProductConsumerR pcr=new ProductConsumerR();
        for(int i=0;i<10;i++){
            new Thread(pcr.new Producer()).start();
            new Thread(pcr.new Consumer()).start();
        }
    }
    class Producer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try{
                    while (count==FULL){
                        try {
                            notFullCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                    notEmptyCondition.signal();
                }finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10;i++){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count==0){
                        notEmptyCondition.await();
                    }
                    count--;
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 总共有 " + count + " 个资源");
                    notFullCondition.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
