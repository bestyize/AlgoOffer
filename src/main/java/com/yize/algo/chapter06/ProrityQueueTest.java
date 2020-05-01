package com.yize.algo.chapter06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProrityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        Integer[] array1={8,6,7,1,2,3,4,5,6};
        Integer[] array2={8,6,7,1,2,3,4,5,6};
        priorityQueue.addAll(Arrays.asList(array1));
        System.out.println(priorityQueue);
        PriorityQueue<Integer> priorityQueue1=new PriorityQueue<>(Comparator.reverseOrder());

        PriorityQueue<Integer> prorityQ=new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
        priorityQueue1.addAll(Arrays.asList(array2));
        while (priorityQueue1.isEmpty()==false){
            System.out.println(priorityQueue1.poll());
        }

        System.out.println(Integer.MAX_VALUE);

    }
}
