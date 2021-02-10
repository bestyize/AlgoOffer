package thewind.bdtest;


import org.junit.Test;
import thewind.common.TreeNode;

public class T1TreeSumNumber {

    @Test
    public void test(){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        System.out.println(treeSum(root));
    }


    public int treeSum(TreeNode root){
        treeSum(root,0);
        return sum;
    }
    int sum=0;
    public void treeSum(TreeNode root,int prev){
        if(root!=null){
            int val=prev*10+root.val;
            if(root.left==null&&root.right==null){
                sum+=val;
            }
            treeSum(root.left,val);
            treeSum(root.right,val);

        }
    }
}
