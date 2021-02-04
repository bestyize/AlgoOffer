package thewind.high;

import org.junit.Test;
import xyz.thewind.common.ListNode;

public class ReverseListNode {

    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4});
        reverseNode(head).print();
    }

    public ListNode reverseNode(ListNode head){
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
}
