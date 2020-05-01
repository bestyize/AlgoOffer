package com.yize.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class L146 {
    class Node{
        public int key,val;
        public Node next,prev;
        public Node(int k,int v){
            this.key=k;
            this.val=v;
        }
    }
    class DoubleList{
        private Node head,tail;
        private int size;
        public DoubleList(){
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.next=head;
            head.prev=tail;
            tail.prev=head;
            size=0;
        }

        public void addFirst(Node node){
            node.next=head.next;
            node.prev=head;
            head.next.prev=node;
            head.next=node;
            size++;
        }

        public void remove(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
            size--;
        }

        public Node removeLast(){
            if(tail.prev==head){
                return null;
            }
            Node last=tail.prev;
            remove(last);
            return last;
        }

        public int size(){
            return size;
        }
    }
    class LRUCache {
        private HashMap<Integer,Node> map;
        private DoubleList cache;
        private int cap;
        public LRUCache(int capacity) {
            this.cap=capacity;
            map=new HashMap<>();
            cache=new DoubleList();
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            int val=map.get(key).val;
            put(key,val);
            return val;
        }

        public void put(int key, int value) {
            Node node=new Node(key,value);
            if(map.containsKey(key)){
                cache.remove(map.get(key));
                cache.addFirst(node);
                map.put(key,node);
            }else {
                if(cap==cache.size()){
                    Node lastNode=cache.removeLast();
                    map.remove(lastNode.key);
                }
                cache.addFirst(node);
                map.put(key,node);
            }
        }
    }

    public static void main(String[] args) {
//        LinkedHashMap map=new LinkedHashMap(16,0.75f,true){
//            protected boolean removeEldestEntry(Map.Entry e){
//
//                return size()>capacity;
//            }
//        };
    }
}
