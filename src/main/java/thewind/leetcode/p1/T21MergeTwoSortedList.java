package thewind.leetcode.p1;

import org.junit.Test;
import thewind.common.ListNode;


/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T21MergeTwoSortedList {

    @Test
    public void test(){
        ListNode l1=ListNode.buildList(new int[]{1,1,3,5});
        ListNode l2=ListNode.buildList(new int[]{2,4,6});
        mergeTwoLists(l1,l2).print();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        while (l1!=null||l2!=null){
            if(l1==null){
                curr.next=l2;
                break;
            }else if(l2==null){
                curr.next=l1;
                break;
            }else {
                if(l1.val<=l2.val){
                    curr.next=new ListNode(l1.val);
                    l1=l1.next;
                }else {
                    curr.next=new ListNode(l2.val);
                    l2=l2.next;
                }
                curr=curr.next;
            }
        }
        return dummy.next;
    }
}
