package thewind.leetcode.p1;

import org.junit.Test;
import thewind.common.ListNode;


/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 *
 *
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 */
public class T24SwapTwoListPair {

    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4});
        swapPairs(head).print();
    }

    //1 2 3 4
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        ListNode prevHead=dummy;
        ListNode curr=head;
        while (curr!=null){
            int k=2;
            ListNode prev=null;
            ListNode lastNode=curr;
            while (curr!=null&&k-->0){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
            }
            prevHead.next=prev;
            prevHead=lastNode;
        }
        return dummy.next;

    }
}
