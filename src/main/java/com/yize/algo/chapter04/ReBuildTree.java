package com.yize.algo.chapter04;

import com.yize.datastructure.TreeNode;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReBuildTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return null;
    }

    private TreeNode rebuild(int [] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        TreeNode head=new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==pre[preStart]){
                //head.left=rebuild(pre,preStart+1,preStart+i-inStart,)
            }
        }
        return null;
    }
}
