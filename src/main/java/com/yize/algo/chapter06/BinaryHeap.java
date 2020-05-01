package com.yize.algo.chapter06;

/**
 * 优先队列时至少允许以下两种操作的数据结构：insert(插入)、deleteMin(删除最小者)，
 * 他的作用是找出、返回并删除优先队列中的最小者，insert操作相当于入队enqueue,而
 * deleteMin相当于出队dequeue.
 * 用链表（插入删除都是N）和二叉查找树（插入删除都是O(log(N))）都能实现优先队列
 * 而一般使用二叉堆实现。堆是一颗被完全填满的二叉树，成为完全二叉树。完全二叉树从上到下，从左到右依次填充
 * 所以可以用一个数组表示。对于数组中任意位置i的的元素，其左儿子在位置2i处，右儿子在2i+1处。，其父亲位于i/2处
 * 一个堆结构由一个数组和一个代表当前堆大小的整数组成
 */

import java.nio.BufferUnderflowException;
import java.util.Arrays;

/**
 * 堆序性质(heap-order property)。由于我们想要尽快找出最小元，
 * 因此最小元应该在根上，而且任意子树也应该是一个堆，任意节点都小于他的后裔
 */
public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY=10;
    private int currentSize;
    private T[] array;

    /**
     * 从数组构建堆
     * @param items
     */
    public BinaryHeap(T[] items){
        currentSize=items.length;
        array=(T[]) new Comparable[(currentSize+2)*11/10];
        int i=1;
        for(T item:items){
            array[i++]=item;
        }
        buildHeap();
    }

    /**
     * 为了保证树为完全二叉树，我们在下一个位置创建一个空穴，然后上滤到对应位置，直到找到正确位置
     * @param x
     */
    public void insert(T x){
        if(currentSize==array.length-1){
            enlargeArray(currentSize*2+1);
        }
        int hole=++currentSize;
        //怎么比的？先把要插入的数据放在array[0]位置处，然后比较一下array[hole]的父节点
        //也就是array[hole/2]的大小，如果我小于父节点大小，那我就属于这个hole的位置
        //否则的话，把父节点换到hole位置，然后hole上滤到父节点位置
        //下面就是上滤的程序
        for (array[0]=x;x.compareTo(array[hole>>1])<0;hole<<=1){
            array[hole]=array[hole>>1];
        }
        //最后给hole位置赋值即可
        array[hole]=x;
    }

    public T findMin(){
        if(currentSize<1){
            throw new ArrayIndexOutOfBoundsException("堆中元素为空");
        }
        return array[1];
    }

    /**
     * 删除最小元。
     * 删除最小元的时候需要在根节点建立一个空穴hole,并且最后一个元素要移动到自己应在的位置
     * 怎么寻找自己的位置？
     * 将根节点置为hole后，将两个儿子中较小的儿子置入hole的位置，hole下滑到较小儿子位置，
     * 假如hole的位置为i,那么它下滤位置为2i或者2i+1，具体取决于它两个儿子的大小。
     * hole下滤到成为叶子节点之后下滤结束
     * 最后，原本的最后一个元素放置到hole最后下滤位置
     * @return
     */
//    public T deleteMin(){
//        T min=findMin();
//        int hole=1;
//        while ((hole<<1)<=currentSize){
//            int nextHole=hole<<1;
//            if(nextHole!=currentSize&&array[nextHole].compareTo(array[nextHole+1])>0){
//                nextHole++;
//            }
//            array[hole]=array[nextHole];
//            hole=nextHole;
//        }
//        array[hole]=array[currentSize];
//        currentSize--;
//        return min;
//    }
    public T deleteMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        T min=findMin();
        array[1]=array[currentSize];
        currentSize--;
        percolateDown(1);
        return min;
    }

    public boolean isEmpty(){
        return currentSize<1;
    }

    public void makeEmpty(){
        currentSize=0;
        array=(T[])new Object[DEFAULT_CAPACITY];
    }


    /**
     * 建立堆,为什么要从大向小过滤？
     * 先把大的过滤完了
     */
    private void buildHeap() {
        for(int i=currentSize>>1;i>0;i--){
            percolateDown(i);
        }
    }

    private void percolateDown(int hole) {
        T temp=array[hole];
        while ((hole<<1)<=currentSize){
            int nextHole=hole<<1;
            if((currentSize!=nextHole)&&array[nextHole].compareTo(array[nextHole+1])>0){
                nextHole=nextHole+1;
            }
            if(array[nextHole].compareTo(temp)<0){
                array[hole]=array[nextHole];
            }else {
                break;
            }
            hole=nextHole;
        }
        array[hole]=temp;
    }

    /**
     * 扩容数组
     * @param newSize
     */
    private void enlargeArray(int newSize){
        if(newSize<currentSize){
            return;
        }
        T[] old=array;
        array=(T[])new Comparable[newSize];
        for(int i=1;i<old.length;i++){
            array[i]=old[i];
        }
    }

    public static void main(String[] args) {
        Integer[] array={5,4,2,3,1,6};
        BinaryHeap<Integer> heap=new BinaryHeap<>(array);
        System.out.println(heap);
        heap.deleteMin();
        System.out.println(heap);
        heap.deleteMin();
        System.out.println(heap);
        heap.insert(9);
        System.out.println(heap);
        heap.insert(11);
        System.out.println(heap);
        heap.insert(9);
        System.out.println(heap);
        heap.insert(9);
        System.out.println(heap);
    }

    @Override
    public String toString() {
        T[] temp=(T[])new Comparable[currentSize];
        for(int i=1;i<=currentSize;i++){
            temp[i-1]=array[i];
        }
        return Arrays.toString(temp);
    }
}
