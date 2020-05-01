package com.yize.newcoder.ali;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 算法：判断一个链表是否回文
 */
public class T1 {
    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{2,4,1,4,2});
        System.out.println(isHuiwen(head));
    }

    public boolean isHuiwen(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        Stack<Integer> stack=new Stack<>();
        ListNode quick=head.next.next;
        ListNode slow=head;
        stack.push(slow.val);
        while (quick!=null&&quick.next!=null){
            slow=slow.next;
            stack.push(slow.val);
            quick=quick.next.next;
        }
        slow=slow.next.next;
        while (slow!=null){
            if(slow.val!=stack.pop()){
                return false;
            }
            slow=slow.next;
        }

        return true;


    }
}
