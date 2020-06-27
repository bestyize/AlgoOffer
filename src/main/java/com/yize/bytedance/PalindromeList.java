package com.yize.bytedance;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.Stack;

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

    /**
     * 解题思路：在找中点的时候对前半部分进行翻转,时空复杂度为n和1
     * @param head
     * @return
     */
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

    /**
     * 用栈性质实现
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head){
        Stack<ListNode> stack=new Stack<>();
        ListNode curr=head;
        while (curr!=null){
            stack.push(curr);
            curr=curr.next;
        }
        while (head!=null){
            if(head.val!=stack.pop().val){
                return false;
            }
            head=head.next;
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
