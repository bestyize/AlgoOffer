package com.yize.algo;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class AlgoTest {
    final class Book{
        int id=0;
    }


    @Test
    public void tet(){
        final int[] buf={1,2,3};
        buf[0]=4;
        System.out.println(buf[0]);
        final Book book=new Book();
        book.id=20;
        System.out.println(book.id);
        LinkedHashMap<Object,Object> map=new LinkedHashMap<>();
        map.put(1,1);
        map.get(1);
        ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
        threadLocal.set(1);
        ArrayList<Integer> l=new ArrayList<>();
    }
    @Test
    public void test(){
        MyQueue queue=new MyQueue();
        MyStack stack=new MyStack();
        for (int i=0;i<10;i++){
            queue.offer(i);
            stack.offer(i);
        }
        while (queue.isEmpty()==false){
            System.out.print(queue.poll());
        }
        System.out.println();
        while (stack.isEmpty()==false){
            System.out.print(stack.poll());
        }
    }

    class MyStack{
        private Queue<Integer> queue;
        private int count=0;
        public MyStack() {
            queue=new LinkedList<>();
        }

        public void offer(int val){
            queue.offer(val);
            for (int i=0;i<count;i++){
                queue.offer(queue.poll());
            }
            count++;
        }
        public int poll(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            count--;
            return queue.poll();
        }
        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }

     class MyQueue{
        private Stack<Integer> input;
        private Stack<Integer> output;

        public MyQueue() {
            input =new Stack<>();
            output = new Stack<>();
        }

        public void offer(int val){
            input.push(val);
        }
        public int poll(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            if(output.size()==0){
                while (input.isEmpty()==false){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }
        public boolean isEmpty(){
            return input.isEmpty()&&output.isEmpty();
        }

    }


}
