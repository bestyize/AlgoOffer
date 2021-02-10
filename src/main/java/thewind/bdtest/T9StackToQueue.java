package thewind.bdtest;

import java.util.Stack;

public class T9StackToQueue {
    public class MyQueue<T>{
        private Stack<T> input;
        private Stack<T> output;
        private int size;

        public MyQueue() {
            input=new Stack<>();
            output=new Stack<>();
            size=0;
        }

        public void offer(T t){
            input.push(t);
        }

        public T poll(){
            if(isEmpty()){
                throw new RuntimeException("已空");
            }else {
                while (output.isEmpty()){
                    output.push(input.pop());
                }
            }
            size--;
            return output.pop();
        }

        public int size(){
            return size;
        }
        public boolean isEmpty(){
            return size==0;
        }


    }
}
