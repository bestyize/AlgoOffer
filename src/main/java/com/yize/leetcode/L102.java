package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L102 {



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists=new ArrayList<>();
        if(root==null){
            return lists;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode node=root;
        queue.offerFirst(node);
        while (queue.isEmpty()==false){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curNode=queue.pollLast();
                list.add(curNode.val);
                if(curNode.left!=null){
                    queue.offerFirst(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offerFirst(curNode.right);
                }
            }
            lists.add(list);
        }
        return lists;

    }
}
