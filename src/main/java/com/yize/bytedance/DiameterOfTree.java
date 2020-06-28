package com.yize.bytedance;

import com.yize.datastructure.TreeNode;

/**
 * 求二叉树的最大直径
 */
public class DiameterOfTree {

    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;

    }
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDepth=depth(root.left);
        int rightDepth=depth(root.right);
        int currMax=leftDepth+rightDepth;
        max=Math.max(max,currMax);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
