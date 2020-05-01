package com.yize.newcoder.bytedance;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 算法题：二叉树转双向链表（中序非递归遍历修改指针）
 */
public class T24 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        TreeNode n=convertToList(node1);
        System.out.println(n);

    }

    public TreeNode convertToList(TreeNode head){
        if (head==null){
            return head;
        }
        Stack<TreeNode> stack=new Stack<>();
        List<TreeNode> nodes=new ArrayList<>();
        while (stack.size()>0||head!=null){
            if(head!=null){
                stack.push(head);
                nodes.add(head);
                head=head.left;
            }else {
                head=stack.pop();
                head=head.right;
            }
        }
        nodes.get(0).left=null;
        nodes.get(0).right=nodes.size()==1?null:nodes.get(1);
        for (int i=1;i<nodes.size()-1;i++){
            nodes.get(i).left=nodes.get(i-1);
            nodes.get(i).right= nodes.get(i+1);
        }
        nodes.get(nodes.size()-1).right=null;
        return nodes.get(0);
    }

}
