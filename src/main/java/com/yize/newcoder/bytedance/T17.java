package com.yize.newcoder.bytedance;

import com.yize.datastructure.TreeNode;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * 反转二叉树
 * https://www.nowcoder.com/discuss/386830?type=post&order=time&pos=&page=1&subType=2
 */
public class T17 {
    @Test
    public void test() {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        TreeNode n=inverseTree(node1);
        System.out.println(n);

    }

    public TreeNode inverseTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        inverseTree(node.left);
        inverseTree(node.right);
        return node;
    }
}