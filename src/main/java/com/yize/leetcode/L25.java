package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class L25 {

    @Test
    public void test(){
        ListNode h=ListNode.buildListNode(new int[]{1,2,3,4,5});
        reverseKGroup(h,2).print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode currHead=dummy;//前一段头插法得到链表的尾部
        ListNode curr=head;//现在的节点
        ListNode prev=null;//前一个结点

        while(curr!=null){
            int count=k;
            ListNode endNode=curr;
            while(curr!=null&&count-->0){//k个一组反转链表 例如12345 翻转一次prev=21,curr=345
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            if(count>0){//如果count>0说明最后剩下的不用翻转，所以在下面将这一段重新翻转，接到后面就可以
                curr=prev;
                prev=null;
                while(curr!=null){
                    ListNode temp=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=temp;
                }
                currHead.next=prev;
            }else{
                currHead.next=prev;//前一段头插结果的尾部接上这段头插的头部
                currHead=endNode;//本段结果的尾部
                prev=null;//下一段头插的前一个结点置为null
            }

        }
        return dummy.next;
    }
}
