package thewind.bytedance;

import org.junit.Test;
import thewind.common.ListNode;


import java.util.Stack;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class T12TwoSumAdd {

    @Test
    public void test(){
        ListNode l1=ListNode.buildList(new int[]{5,4,5});
        ListNode l2=ListNode.buildList(new int[]{5,6,5});
        addTwoNumbers(l1,l2).print();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int val=0;
        while (l1!=null||l2!=null){
            if(l1!=null){
                val+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                val+=l2.val;
                l2=l2.next;
            }
            curr.next=new ListNode(val%10);
            curr=curr.next;
            val/=10;
        }
        if(val!=0){
            curr.next=new ListNode(val);
        }
        return dummy.next;
    }

    public ListNode addTwoNumberII(ListNode l1,ListNode l2){
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while (l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        ListNode curr=null;
        int addIn=0;
        while (!s1.isEmpty()||!s2.isEmpty()||addIn!=0){
            int sum=addIn;
            if(s1!=null){
                sum+=s1.pop();
            }
            if(s2!=null){
                sum+=s2.pop();
            }
            ListNode node=new ListNode(sum%10);
            node.next=curr;
            curr=node;
            addIn=sum/10;
        }
        return curr;
    }
}
