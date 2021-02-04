package thewind.bytedance;

import xyz.thewind.common.ListNode;

/**
 *
 * 1  2  4 5
 *       7 6
 *
 */

public class T38ListHasCircle {
    public boolean hasCircle(ListNode head){
        if(head==null||head.next==null){
            return false;
        }
        ListNode quick=head;
        ListNode slow=head;
        while (quick!=null&&quick.next!=null){//假如链表没有环，此循环会推出
            quick=quick.next.next;
            slow=slow.next;
            /**
             * //快慢指针，会相遇，假设在第n次移动时相遇，
             * 那么慢指针移动n个，快指针移动2n,设a为环长度，b为单链表长度，相遇点为x,相遇时慢指针围着圈转了i圈，快指针转了j圈
             * 因为快指针的速度是慢指针的2倍，最极端的情况是快指针到达入口点，慢指针到环形链表入口对端前的一个点，因第一次相遇时，i一定等于0,
             *
             * x+b=n
             * x+ja+b=2n
             *
             * x+ja+b=2x+2b
             * x=ja-b
             *
             */
            if(quick==slow){
                quick=head;
                while (head!=slow){
                    quick=quick.next;
                    slow=slow.next;
                }
            }
        }
        return false;
    }
}
