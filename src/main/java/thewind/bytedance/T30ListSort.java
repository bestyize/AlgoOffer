package thewind.bytedance;


import thewind.common.ListNode;

public class T30ListSort {
    public ListNode sortList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head,quick=head;
        ListNode midNode=null;
        while (quick!=null&&quick.next!=null){
            midNode=slow;
            quick=quick.next;
            slow=slow.next;
        }
        midNode.next=null;
        ListNode leftHead=sortList(head);
        ListNode rightHead=sortList(slow);
        return merge(leftHead,rightHead);
    }

    public ListNode merge(ListNode left,ListNode right){
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (left!=null&&right!=null){
            if(left.val<=right.val){
                curr.next=new ListNode(left.val);
                left=left.next;
            }else {
                curr.next=new ListNode(right.val);
                right=right.next;
            }
            curr=curr.next;
        }
        curr.next=left==null?right:left;
        return dummy.next;
    }
}
