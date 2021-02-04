package thewind.bytedance;

import xyz.thewind.common.ListNode;

public class T2RemoveLastNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode quick=head,slow=dummy;
        while (quick!=null&&n-->0){
            quick=quick.next;
        }
        if(n>0){
            return null;
        }
        while (quick!=null){
            quick=quick.next;
            slow=slow.next;
        }
        if(slow.next!=null){
            slow.next=slow.next.next;
        }
        return dummy.next;

    }
}
