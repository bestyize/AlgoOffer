package com.yize.leetcode;

import com.yize.datastructure.ListNode;
import org.junit.Test;

import java.util.*;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return method1(lists);
    }

    /**
     * 普通方法
     * @param lists
     * @return
     */
    public ListNode method1(ListNode[] lists){
        List<ListNode> list=new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            while (lists[i]!=null){
                list.add(lists[i]);
                lists[i]=lists[i].next;
            }
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.val>o2.val){
                return 1;
            }else if(o1.val<o2.val){
                return -1;
            }else {
                return 0;
            }
        });
        ListNode dummy=new ListNode(-1);
        ListNode currNode=dummy;
        for(int i=0;i<list.size();i++){
            currNode.next=list.get(i);
            currNode=currNode.next;
        }
        return dummy.next;
    }

    @Test
    public void test(){
        ListNode n1=ListNode.buildListNode(new int[]{-2,-1,-1,-1});
        ListNode n2=null;
        ListNode[] n={n1,n2};
        mergeKLists2(n).print();
        System.out.println();
    }
    //使用堆优化
    public ListNode mergeKLists2(ListNode[] lists) {
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
        return  dummy.next;
    }
    //逐层扫描
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(true){
            int min=Integer.MAX_VALUE;
            int minIndex=-1;
            for(int i=0;i<lists.length;i++){
                ListNode node=lists[i];
                if(node!=null&&node.val<min){
                    minIndex=i;
                    min=node.val;
                }
            }
            if(minIndex!=-1){
                curr.next=lists[minIndex];
                curr=curr.next;
                lists[minIndex]=lists[minIndex].next;
            }else{
                return dummy.next;
            }
        }
    }
}
