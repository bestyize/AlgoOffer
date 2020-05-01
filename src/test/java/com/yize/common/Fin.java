package com.yize.common;

import com.yize.datastructure.ListNode;

public class Fin {

    public static void main(String[] args) {
        ListNode head=ListNode.buildListNode(new int[]{1,2,3,4,5});
        rotateRight(head,1).print();
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0){
            return head;
        }
        ListNode node=head;
        int len=0;
        while (node!=null&&node.next!=null){
            node=node.next;
            len++;
        }
        len++;
        k=len-k%len;//计算偏移
        node.next=head;//成环
        while (k>1){
            head=head.next;
            k--;
        }
        ListNode newHead=head.next;
        head.next=null;
        return  newHead;

    }
    public static ListNode rotateRight1(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode node=head;
        int len=0;
        while (node!=null){
            node=node.next;
            len++;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        ListNode quick=head;
        ListNode slow=head;
        while(k>0&&quick!=null){
            quick=quick.next;
            k--;
        }

        while(quick!=null&&quick.next!=null){
            quick=quick.next;
            slow=slow.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;//slow=3
        ListNode curr=newHead;
        while(curr!=null&&curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        return newHead;
    }
}
