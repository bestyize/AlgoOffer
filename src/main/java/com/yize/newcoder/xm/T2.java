package com.yize.newcoder.xm;


import com.yize.datastructure.ListNode;

public class T2 {
    public static void main(String args[]){
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(5);
        ListNode node3=new ListNode(7);
        node1.next=node2;
        node2.next=node3;
        ListNode node4=new ListNode(1);
        ListNode node5=new ListNode(3);
        ListNode node6=new ListNode(6);
        node4.next=node5;
        node5.next=node6;
        merge(node1,node4).print();
    }

    public static ListNode merge(ListNode headA,ListNode headB){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while(headA!=null&&headB!=null){
            if(headA.val<=headB.val){
                curr.next=headA;
                headA=headA.next;
            }else {
                curr.next=headB;
                headB=headB.next;
            }
            curr=curr.next;

        }
        curr.next=headA==null?headB:headA;
        return dummy.next;
    }


}
