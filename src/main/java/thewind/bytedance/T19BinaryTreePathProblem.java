package thewind.bytedance;


import thewind.common.TreeNode;

/**
 * 二叉树路径问题
 */
public class T19BinaryTreePathProblem {
    /**
     * 二叉树最大深度
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
        if((root.left==null&&root.right!=null)||(root.right==null&&root.left!=null)){
            if(root.left==null){
                return 1+minDepth(root.right);
            }else {
                return 1+minDepth(root.left);
            }
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }


    /**
     * 二叉树最大直径
     */
    int maxDiameter=0;
    public int maxDiameter(TreeNode root){
        depth(root);
        return maxDiameter;
    }

    private int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftDepth=depth(node.left);//左深度
        int rightDepth=depth(node.right);//右深度
        int temp=leftDepth+rightDepth;//经过当前节点的最大直径
        maxDiameter=Math.max(maxDiameter,temp);//更新最大直径
        return Math.max(leftDepth,rightDepth)+1;//返回左右直径的最大一支
    }
}
