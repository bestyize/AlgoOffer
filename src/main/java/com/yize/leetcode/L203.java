package com.yize.leetcode;

import com.yize.datastructure.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class L203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode noMatchHead=dummy;
        while(head!=null){
            while(head!=null&&head.val==val){
                head=head.next;
            }
            noMatchHead.next=head;
            noMatchHead=noMatchHead.next;
            if(head!=null){
                head=head.next;
            }

        }
        return dummy.next;
    }
}
