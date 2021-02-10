package thewind.bdtest;

import thewind.common.TreeNode;

public class T16MirrorTree {
    public boolean isMirrorTree(TreeNode root){
        if(root==null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode t1,TreeNode t2){
        if(t1==null&&t2==null){
            return true;
        }
        if ((t1==null&&t2!=null)||(t1!=null&&t2==null)||t1.val!=t2.val) {
            return true;
        }
        return isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
    }
}
