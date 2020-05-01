package com.yize.offer;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Offer_56 {
    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{1,2,3,3,4,5,5});
        deleteDuplication(head).print();
    }

    public ListNode deleteDuplication(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode noDupHead=dummy;
        ListNode dupNode=null;
        ListNode currNode=head;
        while (currNode!=null){
            while (currNode.next!=null&&currNode.val==currNode.next.val){
                dupNode=currNode;
                currNode=currNode.next;
            }
            if(dupNode==null){
                noDupHead.next=currNode;
                noDupHead=currNode;
            }else {
                dupNode=null;
            }
            currNode=currNode.next;
        }
        noDupHead.next=null;
        return dummy.next;

    }
}
