package thewind.bdtest;

import thewind.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T18TreeRecu {
    public void levelRecu(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.print(node.val+" ");
            if(node.left==null){
                queue.offer(node.left);
            }
            if(node.right==null){
                queue.offer(node.right);
            }
        }
    }
}
