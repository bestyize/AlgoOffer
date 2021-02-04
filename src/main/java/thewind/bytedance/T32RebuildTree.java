package thewind.bytedance;

import org.junit.Test;
import xyz.thewind.common.TreeNode;

/**
 * 重建二叉树
 *
 *          0
 *      1       2
 *  3     4  5      6
 *
 * 前序 0 1 3 4 2 5 6
 * 中序 3 1 4 0 5 2 6
 * 后序 3 4 1 5 6 2 0
 *
 */
public class T32RebuildTree {
    @Test
    public void test(){
        int[] preOrder={0,1,3,4,2,5,6};
        int[] inOrder={3,1,4,0,5,2,6};
        TreeNode node=rebuildFromPreIn(preOrder,inOrder);
        System.out.println();
    }

    /**
     * 前序遍历中序遍历恢复二叉树
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode rebuildFromPreIn(int[] preOrder,int[] inOrder){
        return preInRebuild(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
    }
    public TreeNode preInRebuild(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
        int rootVal=preOrder[preStart];
        TreeNode root=new TreeNode(rootVal);
        int leftSize=0;
        for (int i=inStart;i<=inEnd;i++){
            if(inOrder[i]==rootVal){
                leftSize=i-inStart;
                break;
            }
        }
        root.left=preInRebuild(preOrder,preStart+1,preStart+leftSize,inOrder,inStart,inStart+leftSize-1);
        root.right=preInRebuild(preOrder,preStart+leftSize+1,preEnd,inOrder,inStart+leftSize+1,inEnd);
        return root;

    }

}
