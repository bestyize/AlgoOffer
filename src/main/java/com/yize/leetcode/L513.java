package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L513 {

    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);
        while (queue.isEmpty()==false){
            int leayerLen=queue.size();
            for (int i=0;i<leayerLen;i++){
                root=queue.pollLast();
                if(root.right!=null){
                    queue.offerFirst(root.right);
                }
                if(root.left!=null){
                    queue.offerFirst(root.left);
                }

            }

        }
        return root.val;
    }


    public int method1(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);
        int maxLayer=getDepth(root);
        while (queue.isEmpty()==false){
            maxLayer--;
            int leayerLen=queue.size();
            for (int i=0;i<leayerLen;i++){
                TreeNode node=queue.pollLast();
                if(node.left!=null){
                    queue.offerFirst(node.left);
                }
                if(node.right!=null){
                    queue.offerFirst(node.right);
                }
                if(maxLayer==0){
                    return node.val;
                }

            }

        }
        return 0;
    }

    private int getDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        return 1+Math.max(getDepth(node.left),getDepth(node.right));
    }
}
