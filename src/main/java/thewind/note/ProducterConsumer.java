package thewind.note;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducterConsumer {
    private ReentrantLock lock=new ReentrantLock();
    private Condition notFull=lock.newCondition();
    private Condition notEmpty=lock.newCondition();

    private Object[] products=new Object[10];
    private int count;
    public void put(Object obj){
        lock.lock();
        try {
            while (count==products.length){
                notFull.await();
            }
            products[count++]=obj;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public Object take(){
        lock.lock();
        Object item=null;
        try {
            while (count==0){
                notEmpty.await();
            }
            item=products[count--];
            notFull.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
        return item;


    }
}
