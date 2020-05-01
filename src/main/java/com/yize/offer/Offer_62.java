package com.yize.offer;

import com.yize.datastructure.TreeNode;

import java.util.Stack;

public class Offer_62 {
    TreeNode KthNode(TreeNode node, int k) {
        int count=0;
        Stack<TreeNode> stack=new Stack<>();
        while(node!=null||stack.isEmpty()==false){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                if(++count==k){
                    return node;
                }
                node=node.right;
            }
        }
        return null;
    }
}
