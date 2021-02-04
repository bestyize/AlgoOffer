package thewind.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildList(int[] nums){
        ListNode head=new ListNode(nums[0]);
        ListNode curr=head;
        for (int i=1;i<nums.length;i++){
            curr.next=new ListNode(nums[i]);
            curr=curr.next;
        }
        return head;
    }

    public void print(){
        ListNode curr=this;
        while (curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }
        System.out.println();
    }


}
