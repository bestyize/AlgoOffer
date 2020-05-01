package com.yize.common;

import java.util.LinkedList;

public class QueueDemo {
    public static void main(String[] args) {
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i=0;i<10;i++){
            queue.offerLast(i);
            queue.pollFirst();
            queue.peek();
            queue.peekFirst();
        }
        for (int i=0;i<10;i++){
            queue.add(i);
        }
        for (int i:queue){
            System.out.println(i);
        }
    }
}
