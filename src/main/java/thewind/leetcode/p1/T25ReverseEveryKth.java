package thewind.leetcode.p1;

import org.junit.Test;
import xyz.thewind.common.ListNode;

/**
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
public class T25ReverseEveryKth {

    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4,5});
        reverseKGroup(head,2).print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode prevHead=dummy;
        ListNode curr=head;
        while (curr!=null){
            int cnt=k;
            ListNode prev=null;
            ListNode lastNode=curr;
            while (curr!=null&&cnt>0){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
                cnt--;
            }
            if(cnt==0){
                prevHead.next=prev;
                prevHead=lastNode;
            }else {
                curr=prev;
                prev=null;
                while (curr!=null){
                    ListNode temp=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=temp;
                }
                prevHead.next=prev;
            }
        }
        return dummy.next;
    }
}
