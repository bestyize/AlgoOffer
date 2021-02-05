package thewind.note;

public class DeadLock {

    public static Object lockA=new Object();
    public static Object lockB=new Object();

    public static void main(String[] args)throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    methodOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程-2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    methodTwo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"线程-1").start();
    }

    public static void methodOne() throws InterruptedException {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"拿到锁 A");
            Thread.sleep(1000);
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"拿到锁 B");
            }
        }
    }

    public static void methodTwo() throws Exception{
        synchronized (lockB){
            System.out.println(Thread.currentThread().getName()+"拿到锁 B");
            synchronized (lockA){
                System.out.println(Thread.currentThread().getName()+"拿到锁 A");
            }
        }
    }
}
