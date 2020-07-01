package com.yize.bytedance;

import com.yize.datastructure.ListNode;
import org.junit.Test;

public class InverseList {
    @Test
    public void test(){

    }

    /**
     * 反转链表非递归
     * @param head
     * @return
     */
    public ListNode inverseListNode(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    /**
     * 反转链表递归
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseNode(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
