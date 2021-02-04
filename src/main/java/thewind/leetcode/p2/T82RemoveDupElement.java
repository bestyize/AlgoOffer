package thewind.leetcode.p2;

import org.junit.Test;
import xyz.thewind.common.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 通过次数82,759提交次数165,246
 * 在真实的面试中遇到过这道题？
 */
public class T82RemoveDupElement {

    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,3,4,5});
        deleteDuplicates(head).print();
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        while (curr.next!=null&&curr.next.next!=null){
            if(curr.next.val==curr.next.next.val){
                while (curr.next.next!=null&&curr.next.val==curr.next.next.val){
                    curr.next=curr.next.next;
                }
                curr.next=curr.next.next;
            }else {
                curr=curr.next;
            }
        }

        return dummy.next;
    }
}
