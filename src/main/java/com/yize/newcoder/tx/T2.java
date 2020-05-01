package com.yize.newcoder.tx;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class T2 {
    @Test
    public void test(){

    }

    class MyQueue{
        private Stack<Integer> input=new Stack<>();
        private Stack<Integer> output=new Stack<>();
        public void offer(int i){
            input.push(i);
        }

        public int pop(){
            if(output.isEmpty()){
                while (input.isEmpty()==false){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public void top(){

        }
    }
    class MyStack{
        private Queue<Integer> queue=new LinkedList<>();

        public void push(int val){
            queue.offer(val);
            for(int i=0;i<queue.size();i++){
                queue.offer(queue.poll());
            }

        }
        public int pop(){
            return queue.poll();
        }
    }
}
