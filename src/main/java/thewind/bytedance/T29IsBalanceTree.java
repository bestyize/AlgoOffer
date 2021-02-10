package thewind.bytedance;


import thewind.common.TreeNode;

public class T29IsBalanceTree {
    private boolean isBalance=true;
    public boolean isBalanceTree(TreeNode root){
        if(root==null){
            return isBalance;
        }
        getDepth(root);
        return isBalance;
    }
    public int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        if(Math.abs(left-right)>1){
            isBalance=false;
        }
        return Math.max(left,right)+1;
    }
}
