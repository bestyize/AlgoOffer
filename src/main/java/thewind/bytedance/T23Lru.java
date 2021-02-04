package thewind.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * Lru实现
 */
public class T23Lru {

    private class Node{
        Node prev;
        Node next;
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private class DoubleList{
        private int size;
        private final Node head,tail;

        public DoubleList() {
            head=new Node(-1,-1);
            tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
            size=0;
        }

        public void addFirst(Node node){
            head.next.prev=node;
            node.next=head.next;
            node.prev=head;
            head.next=node;
            size++;
        }

        /**
         * 移除之前确保node在双链表中
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

        public int size(){
            return size;
        }
    }

    private class LruCache{
        private Map<Integer,Node> map;
        private DoubleList list;
        private int cap;

        public LruCache(int cap) {
            this.cap = cap;
            map=new HashMap<>((int)(cap*1.75)+1);
            list=new DoubleList();
        }

        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }
            int val=map.get(key).val;
            put(key,val);
            return val;
        }

        public void put(int key,int val){
            Node node=new Node(key,val);
            if(map.containsKey(key)){
                list.addFirst(list.remove(map.get(key)));
                map.put(key,node);
            }else {
                if(list.size>cap){
                    map.remove(list.removeLast());
                }
                list.addFirst(node);
                map.put(key,node);
            }
        }
    }

}
