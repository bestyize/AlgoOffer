package thewind.bytedance;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class T10QueueToStack {

    @Test
    public void test(){
//        MyStack stack=new MyStack();
        Stacks stack=new Stacks();
        for (int i=0;i<10;i++){
            stack.push(i);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }

    /**
     * 两个队列实现栈
     */
    private class Stacks{
        private Queue<Integer> queue;
        private Queue<Integer> helpQueue;
        private int size;
        public Stacks(){
            queue=new LinkedList<>();
            helpQueue =new LinkedList<>();
            size=0;
        }

        public void push(int i){
            while (!queue.isEmpty()){
                helpQueue.offer(queue.poll());
            }
            queue.offer(i);
            while (!helpQueue.isEmpty()){
                queue.offer(helpQueue.poll());
            }
            size++;
        }
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            size--;
            return queue.poll();
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size==0;
        }

    }


    /**
     * 一个队列实现栈
     */
    private class MyStack {
        private Queue<Integer> queue;
        private int size;

        public MyStack() {
            queue=new LinkedList<>();
        }

        public void push(int i){
            queue.offer(i);
            while (size>0){
                size--;
                queue.offer(queue.poll());
            }
            size=queue.size();
        }

        public int pop(){
            if(size==0){
                return -1;
            }
            size--;
            return queue.poll();
        }

        public int size(){
            return size;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }
}
