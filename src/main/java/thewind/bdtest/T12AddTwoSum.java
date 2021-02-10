package thewind.bdtest;

import org.junit.Test;
import thewind.common.ListNode;

import java.util.Stack;

public class T12AddTwoSum {

    @Test
    public void test(){
        ListNode l1=ListNode.buildList(new int[]{1,4,5});
        ListNode l2=ListNode.buildList(new int[]{1,1,1});
        addTwoNumber(l1,l2).print();
    }

    /**
     * 从低到高存储
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int addin=0;
        while (l1!=null||l2!=null||addin!=0){
            if(l1!=null){
                addin+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                addin+=l2.val;
                l2=l2.next;
            }
            curr.next=new ListNode(addin%10);
            curr=curr.next;
            addin=addin/10;
        }
        return dummy.next;
    }

    /**
     * 从高到低存储
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumber(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();

        while (l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }

        while (l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }

        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        int carry=0;
        while (!s1.isEmpty()||!s2.isEmpty()||carry!=0){
            if(!s1.isEmpty()){
                carry+=s1.pop();
            }
            if(!s2.isEmpty()){
                carry+=s2.pop();
            }
            curr.next=new ListNode(carry%10);
            curr=curr.next;
            carry/=10;
        }
        return dummy.next;
    }
}
