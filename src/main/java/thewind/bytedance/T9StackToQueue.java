package thewind.bytedance;

import org.junit.Test;

import java.util.Stack;

public class T9StackToQueue {
    @Test
    public void test(){
        MyQueue queue=new MyQueue();
        for (int i=0;i<10;i++){
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }

    private class MyQueue{
        private Stack<Integer> input;
        private Stack<Integer> output;
        private int size=0;

        public MyQueue() {
            input=new Stack<>();
            output=new Stack<>();
        }

        public void offer(int i){
            input.push(i);
            size++;
        }
        public int poll(){
            if(isEmpty()){
                return -1;
            }
            if(output.isEmpty()){
                while (!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            size--;
            return output.pop();
        }
        public boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return size;
        }
    }
}
