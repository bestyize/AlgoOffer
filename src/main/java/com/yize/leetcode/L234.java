package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;
import java.util.*;
import java.util.Stack;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 通过次数67,359提交次数165,414
 */
public class L234 {
    @Test
    public void test(){
        ListNode head=ListNode.buildListNode(new int[]{1,2,3,2,1});
        System.out.println(isPalindrome(head));
    }

    /**
     * 仅在链表元素数量为偶数时有效
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode reverseHead=null;
        ListNode curr=head,quick=head,slow=head;
        while (quick!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
            ListNode temp=curr.next;

            //反转链表前半部分链表
            curr.next=reverseHead;
            reverseHead=curr;
            curr=temp;

        }
        while (slow!=null){
            if(slow.val!=reverseHead.val){
                return false;
            }
            slow=slow.next;
            reverseHead=reverseHead.next;
        }

        return true;
    }
    public boolean isPalindrome1(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int low=0;
        int high=list.size()-1;
        while (low<high){
            if(list.get(low++).compareTo(list.get(high--))!=0){
                return false;
            }
        }
        return true;
    }
}
