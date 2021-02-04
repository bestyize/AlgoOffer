package thewind.leetcode.p2;

import xyz.thewind.common.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 通过次数177,026提交次数341,025
 */
public class T83RemoveDupNode {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while (curr!=null){
            while (curr.next!=null&&curr.val==curr.next.val){
                curr.next=curr.next.next;
            }
            curr=curr.next;
        }
        return head;
    }
}
