package com.yize.bytedance;

import com.yize.datastructure.ListNode;
import org.junit.Test;

/**
 * ## 2、给一个链表，判断链表元素是否回文，要求空间复杂度O(1)
 *
 * 出处：https://www.nowcoder.com/discuss/442244
 */
public class PalindromeList {
    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{1,2,5,4,2,1});
        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        ListNode quick=head;
        ListNode slow=head;

        ListNode prev=null;
        ListNode curr=head;
        while (quick!=null&&quick.next!=null){
            ListNode temp=slow.next;
            quick=quick.next.next;
            slow=slow.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        if(quick!=null){//奇数个元素,跳过中间节点
            slow=slow.next;
        }
        ListNode frontNode=prev;
        while (frontNode!=null){
            if(frontNode.val!=slow.val){
                return false;
            }
            frontNode=frontNode.next;
            slow=slow.next;
        }
        return true;


    }

    private ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}
