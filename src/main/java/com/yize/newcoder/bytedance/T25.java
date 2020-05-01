package com.yize.newcoder.bytedance;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表复制
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。 
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T25 {
    private Map<Node,Node> map=new HashMap<>();
    public Node copyRandomList1(Node head) {
        if(head==null){
            return head;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }
        Node newNode=new Node(head.val);
        newNode.next=copyRandomList1(head.next);
        newNode.random=copyRandomList1(head.random);
        return newNode;
    }

    @Test
    public void test(){
        Node node0=new Node(7);
        Node node1=new Node(13);

        Node node2=new Node(11);

        Node node3=new Node(10);
        Node node4=new Node(1);
        node0.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        node1.random=node0;
        node2.random=node4;
        node3.random=node2;
        node4.random=node0;
        Node h=copyRandomList(node0);
        System.out.println(h);


    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        //复制主分支节点
        Node curr=head;
        while (curr!=null){
            Node nextNode=curr.next;
            curr.next=new Node(curr.val);//在原节点后面新建一个节点
            curr.next.next=nextNode;//新建节点接上
            curr=nextNode;//调整curr节点的位置到他原来的节点的下一个位置
        }
        //复制随机分支节点
        curr=head;
        while(curr!=null){
            Node nextNode=curr.next.next;
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=nextNode;
        }

        //拆分链表
        curr=head;
        Node newHead=curr.next;
        Node newCurr=newHead;
        while (curr!=null){
            Node nextNode=curr.next.next;
            newCurr.next=nextNode==null?null:nextNode.next;
            newCurr=newCurr.next;
            curr.next=nextNode;
            curr=curr.next;

        }
        return newHead;

    }



    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
