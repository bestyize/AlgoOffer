package thewind.bytedance.sim;

import xyz.thewind.common.ListNode;

/**
 * 判断两个无环单链表是否相交。
 */
public class ListInter {
    /**
     * 复杂方法，找差值，找入口点。简单方法，如果两个链表相交，他们的最后一个元素必然相等。
     * @param l1
     * @param l2
     * @return
     */
    public boolean listInter(ListNode l1,ListNode l2){
        if(l1==null&&l2==null||l1==null&&l2!=null||l1!=null&&l2==null){
            return false;
        }
        int len1=0;
        int len2=0;
        ListNode curr1=l1,curr2=l2;
        while (curr1!=null){
            curr1=curr1.next;
            len1++;
        }
        while (curr2!=null){
            curr2=curr2.next;
            len2++;
        }
        curr1=l1;
        curr2=l2;
        if(len1>len2){
            int len=len1-len2;
            while (len-->0){
                curr1=curr1.next;
            }
        }else if(len2>len1){
            int len=len2-len1;
            while (len-->0){
                curr2=curr2.next;
            }
        }
        while (curr1!=null){
            if(curr1==curr2){
                return true;
            }
            curr1=curr2.next;
            curr2=curr2.next;
        }
        return false;
    }
}
