package com.yize.offer;

import com.yize.datastructure.ListNode;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class T56 {
    public static void main(String[] args) {
        ListNode head=ListNode.buildListNode(new int[]{2,2,3,3,4,4,4});
        deleteDuplication(head).print();
    }

    public static ListNode deleteDuplication(ListNode pHead){
        ListNode dummy=new ListNode(-1);
        ListNode curr=pHead;
        ListNode noDupHead=dummy;
        while(curr!=null){
            if(curr.next!=null&&curr.val==curr.next.val){
                int val=curr.val;
                while(curr!=null&&curr.val==val){
                    curr=curr.next;
                }
            }else{
                noDupHead.next=curr;
                noDupHead=noDupHead.next;
                curr=curr.next;
            }
        }
        noDupHead.next=null;
        return dummy.next;
    }
}
