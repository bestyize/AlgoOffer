package thewind.bdtest;

import org.junit.Test;
import thewind.common.ListNode;

public class T2RemoveLastNNode {

    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4,5});
        removeLastNNode(head,5).print();
    }

    public ListNode removeLastNNode(ListNode head,int n){
        ListNode curr=head;
        int k=n;
        while (curr!=null&&k>0){
            curr=curr.next;
            k--;
        }
        if(k>0){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        while (curr!=null){
            curr=curr.next;
            prev=prev.next;
        }
        if(prev.next!=null){
            prev.next=prev.next.next;
        }
        return dummy.next;

    }
}
