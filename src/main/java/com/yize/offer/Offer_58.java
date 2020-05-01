package com.yize.offer;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 */
public class Offer_58 {
    @Test
    public void test(){
        TreeNode node=new TreeNode(0);
        TreeNode left=new TreeNode(1);
        TreeNode leftLeft=new TreeNode(1);
        TreeNode right=new TreeNode(1);
        TreeNode rightRight=new TreeNode(1);
        node.left=left;
        node.right=right;
        left.left=leftLeft;
        right.right=rightRight;
        System.out.println(isSymmetrical(node));
    }

    boolean isSymmetrical(TreeNode node) {
        return isSymmetrical(node.left,node.right);
    }

    boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if((left==null)||right==null||(left.val!=right.val)){
            return false;
        }
        return isSymmetrical(left.left,right.right)&&isSymmetrical(left.right,right.left);
    }
}
