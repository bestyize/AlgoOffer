package com.yize.newcoder.bytedance;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

public class TreeRightView {
    @Test
    public void test(){
        TreeNode head=new TreeNode(0);
        TreeNode head1=new TreeNode(1);
        TreeNode head2=new TreeNode(2);
        TreeNode head3=new TreeNode(3);
        TreeNode head4=new TreeNode(4);
        head.left=head1;
        head.right=head2;
        head1.left=head3;
        head1.right=head4;
        printTreeRightView(head);
    }

    public void printTreeRightView(TreeNode head){
        if(head==null){
            return;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(head);
        while (!queue.isEmpty()){
            int layerSize=queue.size();
            System.out.print(queue.peekFirst().val+"\t");
            for (int i=0;i<layerSize;i++){
                TreeNode node=queue.pollLast();
                if(node.left!=null){
                    queue.offerFirst(node.left);
                }
                if(node.right!=null){
                    queue.offerFirst(node.right);
                }
            }

        }

    }
}
