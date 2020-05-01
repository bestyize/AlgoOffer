package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.List;

/**
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L147 {

    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{-1,5,3,4,0});
        insertionSortList(head).print();
    }

    /**
     * 执行用时 :
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 98.41%
     * 的用户
     * 内存消耗 :
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 5.10%
     * 的用户
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode finder=dummy;
        ListNode curr=head;
        while (curr!=null){
            if(curr.val<prev.val){
                //找到插入位置
                while (finder.next!=null&&finder.next.val<curr.val){
                    finder=finder.next;
                }
                //当前节点的前一个结点的下一个节点改为当前节点的下一个节点,抽走需要重排的节点
                prev.next=curr.next;
                //重拍的节点后面接上应该插入的位置
                curr.next=finder.next;
                //重排位置的
                finder.next=curr;
                finder=dummy;//恢复
                curr=prev.next;//恢复到挖走的下一个位置
            }else {
                prev=curr;
                curr=curr.next;
            }
        }
        return dummy.next;
    }

    public ListNode insertionSort(ListNode head) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode finder=dummy;
        ListNode curr=head;
        while (curr!=null){
            if(curr.val<prev.val){
                //找到插入位置
                while (finder.next!=null&&finder.next.val<curr.val){
                    finder=finder.next;
                }
                //当前节点的前一个结点的下一个节点改为当前节点的下一个节点
                prev.next=curr.next;

                //备份插入节点头
                ListNode temp=finder.next;

                //第一个小于当前节点的节点的下一个节点变为当前节点
                finder.next=curr;

                //当前节点的下一个节点转为第一个大于他的节点
                curr.next=temp;

                finder=dummy;//恢复
                curr=prev.next;//恢复到挖走的下一个位置
            }else {
                prev=curr;
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}
