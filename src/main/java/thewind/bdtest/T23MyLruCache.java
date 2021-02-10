package thewind.bdtest;

import java.util.HashMap;
import java.util.Map;

public class T23MyLruCache {
    private class Node{
        Node next;
        Node prev;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList{
        Node head;
        Node tail;
        int size;

        public DoubleList() {
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            head.prev=tail;
            tail.prev=head;
            tail.next=head;
            size=0;
        }

        public void addFirst(Node node){
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            node.prev=head;
            size++;
        }

        /**
         * 必须保证里面有Node
         * @param node
         */
        public Node remove(Node node){
            node.next.prev=node.prev;
            node.prev.next=node.next;
            size--;
            return node;
        }

        public Node removeLast(){
            if(size==0){
                return null;
            }
            return remove(tail.prev);
        }

        public boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return size;
        }
    }

    public class LruCache{
        private Map<Integer,Node> map;
        private DoubleList doubleList;
        private int size;
        private int cap;

        public LruCache(int cap) {
            this.cap = cap;
            this.size=0;
            this.doubleList=new DoubleList();
            this.map=new HashMap<>();
        }

        public void put(int key,int val){

            if(map.containsKey(key)){
                Node node=map.get(key);
                node=doubleList.remove(node);
                node.val=val;//更新节点值
                doubleList.addFirst(node);
                map.put(key,node);
            }else {
                Node node=new Node(key,val);
                doubleList.addFirst(node);
                map.put(key,node);
                size++;
            }
            if(size>cap){
                map.remove(doubleList.removeLast().key);
                size--;
            }

        }

        public boolean isEmpty(){
            return size==0;
        }

        public int size(){
            return size;
        }

    }
}
