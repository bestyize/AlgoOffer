package thewind.bytedance;

import xyz.thewind.common.ListNode;

public class T3ReverseNodeEveryK {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode prevHead=dummy;
        ListNode curr=head;
        while (curr!=null){
            int kk=k;
            ListNode prev=null;
            ListNode nextPrevHead=curr;
            while (curr!=null&&kk>0){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
                kk--;
            }
            if(kk==0){
                prevHead.next=prev;
                prevHead=nextPrevHead;
            }else {
                curr=prev;
                prev=null;
                while (kk>0){
                    ListNode temp=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=temp;
                    kk--;
                }
                prevHead.next=prev;
            }
        }
        return dummy.next;
    }
}
