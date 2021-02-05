package thewind.note;

import java.util.concurrent.*;

class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println("Mythread1");
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Mythread2");
    }
}

class Myhtread3 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Mythread3";
    }
}

public class ThreadCreateSimple {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread1 thread1=new MyThread1();
        thread1.start();

        Thread thread2=new Thread(new MyThread2());
        thread2.start();

        FutureTask<String> futureTask=new FutureTask<>(new Myhtread3());
        Thread thread3=new Thread(futureTask);
        thread3.start();
        System.out.println(futureTask.get());

        ExecutorService executor=Executors.newFixedThreadPool(100);

        for (int i=0;i<100;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {

                }
            });
        }

    }
}
