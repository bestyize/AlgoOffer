package com.yize.leetcode;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L98 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(10);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(15);
        TreeNode node4=new TreeNode(6);
        TreeNode node5=new TreeNode(20);
        node1.left=node2;
        node1.right=node3;
        System.out.println(isValidBST(node1));
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        Stack<Integer> valStack=new Stack<>();
        while (root!=null||stack.isEmpty()==false){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                if(!valStack.isEmpty()){
                    if(valStack.peek().compareTo(root.val)>0){
                        return false;
                    }
                }
                valStack.push(root.val);
                root=root.right;
            }
        }
        return true;
    }
}
