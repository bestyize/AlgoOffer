package com.yize.newcoder.bytedance;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * 有两个数字非常大已经超出了long型的范围，现在以链表的方式存储其中链表头表示最高位，例如1->2->3->4表示1234，请设计一个算法求出两数之和；
 */
public class T28 {
    @Test
    public void test(){

    }

    public ListNode twoSum(ListNode num1,ListNode num2){
        ListNode n1=reverse(num1);
        ListNode n2=reverse(num2);
        ListNode result=new ListNode(-1);
        ListNode curr=result;
        int addin=0;
        while (n1!=null||n2!=null){
            int v1=0,v2=0;
            if(n1!=null){
                v1=n1.val;
                n1=n1.next;
            }
            if(n2!=null){
                v1=n2.val;
                n2=n2.next;
            }
            int val=v1+v2+addin;
            curr.next=new ListNode(val%10);
            curr=curr.next;
            addin=val/10;
        }
        if(addin!=0){
            curr.next=new ListNode(addin);
        }
        return reverse(result.next);
    }

    private ListNode reverse(ListNode node){
        ListNode prev=null;
        while(node!=null){
            ListNode temp=node.next;
            node.next=prev;
            prev=node;
            node=temp;
        }
        return prev;
    }
}
