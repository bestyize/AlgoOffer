package com.yize.leetcode;

import com.yize.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 *
 * 示例 1:
 *
 * 输入:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 *
 * 节点值的范围在32位有符号整数范围内。
 */
public class L637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);
        while(queue.isEmpty()==false){
            int layerSize=queue.size();
            double avg=0;
            for(int i=0;i<layerSize;i++){
                TreeNode temp=queue.pollLast();
                avg+=temp.val;
                if(temp.left!=null){
                    queue.offerFirst(temp.left);
                }
                if(temp.right!=null){
                    queue.offerFirst(temp.right);
                }

            }
            result.add((avg+0.0)/layerSize);
        }
        return result;
    }
}
