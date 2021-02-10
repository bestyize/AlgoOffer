package thewind.bdtest;

import org.junit.Test;
import thewind.common.ListNode;

public class T3ReverseNodeEveryK {
    @Test
    public void test(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4,5,6,7,8});
        reverseKGroup(head,3).print();
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        ListNode lastHead=dummy;
        ListNode curr=head;
        while (curr!=null){
            int n=k;
            ListNode prev=null;
            ListNode last=curr;
            while (curr!=null&&n>0){
                ListNode temp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=temp;
                n--;
            }
            if(n==0){
                lastHead.next=prev;
                lastHead=last;
            }else {
                curr=prev;
                prev=null;
                while (curr!=null){
                    ListNode temp=curr.next;
                    curr.next=prev;
                    prev=curr;
                    curr=temp;
                }
                lastHead.next=prev;
            }
        }
        return dummy.next;
    }


    @Test
    public void testReverse(){
        ListNode head=ListNode.buildList(new int[]{1,2,3,4,5});
        reverseList(head).print();
        head=ListNode.buildList(new int[]{1,2,3,4,5});
        reverseListNode(head).print();
    }

    public ListNode reverseList(ListNode head){
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

    public ListNode reverseListNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseListNode(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
