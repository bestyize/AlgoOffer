package com.yize.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Offer_57 {
    /**
     * 给定一个二叉树和其中的一个结点，
     * 请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     */

    /**
     * 最笨的一种方法，找到根节点进行遍历
     * @param node
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode node) {
        ArrayList<TreeLinkNode> nodeArrayList=new ArrayList<TreeLinkNode>();
        TreeLinkNode originNode=node;
        TreeLinkNode headNode=node;
        while (headNode.next!=null){//父节点
            headNode=headNode.next;
        }
        node=headNode;
        Stack<TreeLinkNode> stack=new Stack<TreeLinkNode>();
        while (node!=null||!stack.isEmpty()){

            if(node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                //中序遍历
                if(nodeArrayList.size()>0&&nodeArrayList.get(nodeArrayList.size()-1).val==originNode.val){
                    return node;
                }else {
                    nodeArrayList.add(node);
                }
                node=node.right;
            }
        }
        return null;
    }

    public TreeLinkNode getNextNode(TreeLinkNode node){
        if(node.right!=null){//如果有右子树，则找右子树的最左节点
            node=node.right;
            while (node.left!=null){
                node=node.left;
            }
            return node;
        }else { //没右子树，则找第一个当前节点是父节点左孩子的节点
            while (node.next!=null){
                if(node.next.left==node){
                    return node.next;
                }
                node=node.next;
            }
            return null; //退到了根节点仍没找到，则返回null
        }
    }


    static class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int val){
            this.val=val;
        }
    }
}
