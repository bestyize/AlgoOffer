package thewind.leetcode.p1;

import org.junit.Test;
import xyz.thewind.common.ListNode;

public class T19RemoveLastNNode {

    @Test
    public void test(){
        ListNode list=ListNode.buildList(new int[]{1});
        ListNode r=removeNthFromEnd(list,1);
        r.print();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode quick=head,slow=dummy;
        while (quick!=null&&n-->0){
            quick=quick.next;
        }
        if(quick==null&&n<0){
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
