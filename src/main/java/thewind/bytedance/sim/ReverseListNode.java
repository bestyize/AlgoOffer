package thewind.bytedance.sim;

import org.junit.Test;
import thewind.common.ListNode;


public class ReverseListNode {

    @Test
    public void test(){
        ListNode list=ListNode.buildList(new int[]{1,2,3,4,5});
        list=reversee(list);
        list.print();
    }

    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while (curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }

    public ListNode reversee(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode last=reversee(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
