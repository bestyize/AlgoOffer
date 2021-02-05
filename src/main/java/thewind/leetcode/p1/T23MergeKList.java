package thewind.leetcode.p1;
import thewind.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class T23MergeKList {
    /**
     * nlog(n)
     * @param lists
     * @return
     */
    public ListNode mergeKListsByHeap(ListNode[] lists) {
        PriorityQueue<ListNode> heap=new PriorityQueue<>(((o1, o2) -> o1.val-o2.val));
        for (ListNode node:lists){
            while (node!=null){
                heap.offer(node);
                node=node.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (heap.size()>0){
            curr.next=heap.poll();
            curr=curr.next;
        }
        curr.next=null;
        return dummy.next;
    }


    /**
     * n*MAX(sizeof(list))
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (true){
            int min=Integer.MAX_VALUE;
            int minIndex=-1;
            for (int i=0;i<lists.length;i++){
                if(lists[i]!=null){
                    if(lists[i].val<=min){
                        min=lists[i].val;
                        minIndex=i;
                    }
                }
            }
            if(minIndex==-1){
                break;
            }else {
                curr.next=lists[minIndex];
                curr=curr.next;
                lists[minIndex]=lists[minIndex].next;
            }
        }
        return dummy.next;
    }
}
