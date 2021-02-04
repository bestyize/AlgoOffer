package thewind.leetcode.p1;

import org.junit.Test;
import xyz.thewind.common.ListNode;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class T61RotateList {

    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4,5});
        rotateRight(head,22).print();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int count=1;
        ListNode curr=head;
        while (curr!=null&&curr.next!=null){
            curr=curr.next;
            count++;
        }
        curr.next=head;//成环
        k%=count;
        while (k<count){
            curr=curr.next;
            k++;
        }
        ListNode newHead=curr.next;
        curr.next=null;
        return newHead;

    }
}
