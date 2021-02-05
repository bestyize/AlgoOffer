package thewind.bytedance;

import org.junit.Test;
import thewind.common.TreeNode;


import java.util.*;

/**
 * 二叉树的各种遍历方式
 */
public class T18BinaryTreeRecu {

    /**
C
     */
    @Test
    public void test(){
        TreeNode n0=new TreeNode(0);
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);

        n0.left=n1;
        n0.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;

        preRecuBack(n0);
        System.out.println();
        inRecuBack(n0);
        System.out.println();
        postRecuBack(n0);
        System.out.println();
        System.out.println("************************");
        preRecu(n0);
        System.out.println();
        inRecu(n0);
        System.out.println();
        postRecu(n0);
        System.out.println("\n************************");
        levelRecu(n0);
        System.out.println("\n************************");
        levelRec(n0);

    }

    /**
     * 前序遍历，递归
     * @param root
     */
    public void preRecuBack(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preRecuBack(root.left);
            preRecuBack(root.right);
        }
    }
    /**
     * 中序遍历，递归
     * @param root
     */
    public void inRecuBack(TreeNode root){
        if(root!=null){
            inRecuBack(root.left);
            System.out.print(root.val+" ");
            inRecuBack(root.right);
        }
    }
    /**
     * 后序遍历，递归
     * @param root
     */
    public void postRecuBack(TreeNode root){
        if(root!=null){
            postRecuBack(root.left);
            postRecuBack(root.right);
            System.out.print(root.val+" ");

        }
    }

    /**
     * 谦虚非递归遍历
     * @param root
     */
    public void preRecu(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                System.out.print(root.val+" ");
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                root=root.right;
            }
        }
    }

    /**
     * 中序非递归
     * @param root
     */
    public void inRecu(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else {
                root=stack.pop();
                System.out.print(root.val+" ");
                root=root.right;
            }
        }
    }

    /**
     * 后续非递归
     * @param root
     */
    public void postRecu(TreeNode root){
        List<Integer> list=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                list.add(0,root.val);
                root=root.right;
            }else {
                root=stack.pop();
                root=root.left;
            }
        }
        for (Integer i:list){
            System.out.print(i+" ");
        }
    }


    /**
     * 层序遍历，可以解决右视图，按行打印等等
     * @param root
     */
    public void levelRecu(TreeNode root){
        if(root==null){
            return;
        }
        List<Integer> list=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()){
            int layerSize=queue.size();
            for (int i=0;i<layerSize;i++){
                TreeNode curr=queue.pollLast();
                list.add(curr.val);
                if(curr.left!=null){
                    queue.offerFirst(curr.left);
                }
                if(curr.right!=null){
                    queue.offerFirst(curr.right);
                }
            }
        }
        for (int i:list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public void levelRec(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
    }


}
