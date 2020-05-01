package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L143 {
    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{1,2,3,4,5,6});
        reorderList(head);
        head.print();
    }

    public void reorderList(ListNode head) {
        ListNode slow=head,quick=head;
        ListNode prev=null;
        while(quick!=null&&quick.next!=null){
            prev=slow;
            slow=slow.next;
            quick=quick.next.next;
        }
        if(prev!=null){
            prev.next=null;
        }
        slow=reverseNode(slow);
        ListNode curr=head;
        ListNode endNode=null;
        while (curr!=null){
            endNode=curr;
            ListNode temp=curr.next;
            ListNode tem=slow.next;
            curr.next=slow;
            curr.next.next=temp;
            curr=temp;
            slow=tem;
        }
        if(slow!=null){
            endNode.next.next=slow;
        }
        System.out.println();
    }

    public ListNode reverseNode(ListNode node){
        ListNode prev=null;
        ListNode curr=node;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
