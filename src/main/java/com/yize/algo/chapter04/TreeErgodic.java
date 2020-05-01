package com.yize.algo.chapter04;

import com.yize.datastructure.TreeNode;
import org.apache.log4j.Logger;
import org.junit.Test;


import java.util.*;

/**
 *  * 输入: [1,null,2,3]
 *  *    1
 *  *  /  \
 *  * 2    3
 *  *     /  \
 *  *    4     5
 *  *  /  \   / \
 *  * 6    7 8   9
 *  *先序：[1, 2, 3, 4, 5]
 *  *中序：[2, 1, 4, 3, 5]
 *  *后序：[2, 4, 5, 3, 1]
 *  *中序： [1, 2, 3, 4, 5]
 */
public class TreeErgodic {
    List<Integer> lists=new ArrayList<>();
    @Test
    public void test(){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        TreeNode node7=new TreeNode(7);
        TreeNode node8=new TreeNode(8);
        TreeNode node9=new TreeNode(9);
        node1.left=node2;
        node1.right=node3;
        node3.left=node4;
        node3.right=node5;
        node4.left=node6;
        node4.right=node7;
        node5.left=node8;
        node5.right=node9;
        //System.out.println(backRecuErgodic(node1));
        System.out.println(levelReverseErgodic(node1));

    }

    /**
     * 先序递归遍历
     * @return
     */
    public List<Integer> preRecuErgodic(TreeNode node){
        if(node!=null){
            lists.add(node.val);
            preRecuErgodic(node.left);
            preRecuErgodic(node.right);
        }
        return lists;
    }

    /**
     * 先序非递归
     * @param node
     * @return
     */
    public List<Integer> preNoRecuErgodic(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        while (node!=null||stack.isEmpty()==false){
            if(node!=null){
                lists.add(node.val);
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                node=node.right;
            }
        }
        return lists;
    }

    /**
     * 中序递归
     * @param node
     * @return
     */
    public List<Integer> inRecuErgodic(TreeNode node){
        if(node!=null){
            inRecuErgodic(node.left);
            lists.add(node.val);
            inRecuErgodic(node.right);
        }
        return lists;
    }

    /**
     * 中序非递归
     * @param node
     * @return
     */
    public List<Integer> inNoRecuErgodic(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        while (stack.isEmpty()==false||node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                lists.add(node.val);
                node=node.right;
            }
        }
        return lists;
    }

    /**
     * 后序递归
     * @param node
     * @return
     */
    public List<Integer> backRecuErgodic(TreeNode node){
        if(node!=null){
            backRecuErgodic(node.left);
            backRecuErgodic(node.right);
            lists.add(node.val);
        }
        return lists;
    }

    /**
     * 后序非递归 [2, 4, 5, 3, 1]
     * @param node
     * @return
     */
    public List<Integer> backNoRecuErgodic(TreeNode node){
        Stack<TreeNode> stack=new Stack<>();
        while (stack.isEmpty()==false||node!=null){
            if(node!=null){
                stack.push(node);
                lists.add(0,node.val);//头插正好逆序。后序遍历和前序遍历是镜像问题
                node=node.right;
            }else {
                node=stack.pop();
                node=node.left;
            }
        }
        return lists;
    }

    /**
     *  *    1
     *  *  /  \
     *  * 2    3
     *  *     / \
     *  *    4   5
     *  *
     *  *二叉树层序遍历,水平遍历
     * @param node
     * @return
     */
    public List<Integer> levelNoRecuErgodic(TreeNode node){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            node=queue.poll();
            lists.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return lists;
    }

    /**
     * 之字形遍历，利用LinkedList双向链表既可作栈又可以做队列
     * @param node
     * @return
     */
    public List<Integer> levelReverseErgodic(TreeNode node){
        List<Integer> resultList=new LinkedList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(node);//做队列
        boolean startLeft=true;
        while (!queue.isEmpty()){
            int size=queue.size();//获取该层长度
            List<Integer> layer=new LinkedList<>();
            for (int i=0;i<size;i++){
                TreeNode lastNode=queue.pollLast();//做栈，先进后出
                if(lastNode.left!=null){
                    queue.offerFirst(lastNode.left);
                }
                if(lastNode.right!=null){
                    queue.offerFirst(lastNode.right);
                }
                if(startLeft){
                    layer.add(lastNode.val);
                }else {
                    layer.add(0,lastNode.val);
                }
            }
            resultList.addAll(layer);
            startLeft=!startLeft;
        }
        return resultList;
    }




}
