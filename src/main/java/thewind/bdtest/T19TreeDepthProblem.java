package thewind.bdtest;

import thewind.common.TreeNode;

public class T19TreeDepthProblem {

    /**
     * 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }

    /**
     * 二叉树最小深度
     * @param root
     * @return
     */
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left!=null&&root.right==null){
            return 1+minDepth(root.left);
        }
        if(root.right!=null&&root.left==null){
            return 1+minDepth(root.right);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));

    }

    int maxDiameter =0;
    /**
     * 二叉树直径
     * @param root
     * @return
     */
    public int diameterOfTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMax=diameterOfTree(root.left);
        int rightMax=diameterOfTree(root.right);
        maxDiameter =Math.max(maxDiameter,leftMax+rightMax);
        return 1+Math.max(leftMax,rightMax);
    }
}
