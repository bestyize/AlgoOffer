package com.yize.offer;

import com.yize.datastructure.ListNode;

import java.util.HashMap;

public class Offer_55 {

    public static ListNode EntryNodeOfLoop1(ListNode pHead) {
        if(pHead==null||pHead.next==null){
            return null;
        }
        HashMap<ListNode,Integer> map=new HashMap<ListNode, Integer>();
        ListNode temp=pHead;
        while (!map.containsKey(temp)){
            map.put(temp,1);
            temp=temp.next;
        }
        return temp;
    }

    public ListNode EntryNodeOfLoop(ListNode node) {
        if(node==null||node.next==null){
            return null;
        }
        ListNode slow=node;
        ListNode quick=node;
        while (quick!=null&&quick.next!=null){
            slow=slow.next;
            quick=quick.next.next;
            if(slow==quick){
                quick=node;
                while (quick!=slow){
                    quick=quick.next;
                    slow=slow.next;
                }
                return quick;
            }
        }
        return null;
    }

}
