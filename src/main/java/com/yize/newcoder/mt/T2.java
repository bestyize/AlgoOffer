package com.yize.newcoder.mt;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.Stack;

public class T2 {
    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{1,2,3,4,5});
        reverse(head).print();
    }
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
