package com.yize.offer;


import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
    class Node{
        int val;
        Node prev;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    class DoubleList{
        Node head;
        Node tail;

        public DoubleList() {
            head=new Node(-1);
            tail=new Node(-1);
            head.next=tail;
            head.prev=tail;
            tail.next=head;
            tail.prev=head;
        }

        public void addFirst(Node h){
            h.next=head.next;
            head.next=h;
            h.next.prev=h;
        }

        public Node removeEldest(){
            Node oldest=null;
            if(tail.prev!=head){//不为空
                oldest=tail.prev;
                Node n=tail.prev.prev;
                tail.prev=n;
                n.next=tail;
            }
            return oldest;
        }

        public void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node;
        }

    }

    private HashMap<Integer,Node> map;
    private DoubleList doubleList;

    private int cap;//最大容量
    private int size;
    public LRUCache(int cap) {
        map= new HashMap<>();
        doubleList=new DoubleList();
        this.cap=cap;
    }

    public int get(int key){
        if(isEmpty()||!map.containsKey(key)){
            throw new ArrayIndexOutOfBoundsException("没有找到");
        }
        Node n=map.get(key);
        doubleList.remove(n);
        doubleList.addFirst(n);
        return n.val;
    }

    public void put(int key,int val){
        Node n;
        if(map.containsKey(key)){
            n=map.get(key);
            doubleList.remove(n);
        }else {
            n=new Node(val);
            size++;
        }
        doubleList.addFirst(n);
        map.put(key,n);
        if(size>cap){
            Node oldest=doubleList.removeEldest();
            map.remove(oldest.val);
            size--;
        }

    }

    public boolean isEmpty(){
        return cap==0;
    }

    public int size(){
        return size;
    }

    public void printCache(){
        Node h=doubleList.head.next;
        while (h!=doubleList.tail){
            System.out.print(h.val+"\t");
            h=h.next;
        }
    }

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(8);
        for (int i=0;i<10;i++){
            cache.put(i,i);
        }
        cache.get(3);

        cache.printCache();
    }
}
