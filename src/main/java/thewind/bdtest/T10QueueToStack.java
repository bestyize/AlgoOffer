package thewind.bdtest;

import java.util.LinkedList;
import java.util.Queue;

public class T10QueueToStack<T> {
    public class MyStackOne{
        private int size;
        private Queue<T> queue;

        public MyStackOne() {
            size=0;
            queue=new LinkedList<>();
        }

        public void push(T t){
            queue.offer(t);
            int len=size;
            while (len>0){
                len--;
                queue.offer(queue.poll());
            }
            size++;
        }

        public T pop(){
            if(isEmpty()){
                throw new RuntimeException("无元素");
            }
            size--;
            return queue.poll();
        }

        public boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return size;
        }

    }
}
