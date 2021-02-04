package thewind.bytedance;



import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

/**
 * 二叉树前序遍历迭代器
 */
public class T36PreOrderIterator<T> {

    @Test
    public void test(){
        TreeNode<Integer> n0=new TreeNode(0);
        TreeNode<Integer> n1=new TreeNode(1);
        TreeNode<Integer> n2=new TreeNode(2);
        TreeNode<Integer> n3=new TreeNode(3);
        TreeNode<Integer> n4=new TreeNode(4);
        TreeNode<Integer> n5=new TreeNode(5);
        TreeNode<Integer> n6=new TreeNode(6);

        n0.left=n1;
        n0.right=n2;
        n1.left=n3;
        n1.right=n4;
        n2.left=n5;
        n2.right=n6;

        root=n0;
        TreePreOrderIterator iterator=new TreePreOrderIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }

    private TreeNode root;

    private class TreeNode<T>{
        TreeNode left,right;
        T val;

        public TreeNode(T val) {
            this.val = val;
        }
    }

    private class TreePreOrderIterator implements Iterator<T> {
        private Stack<TreeNode<T>> stack;
        private TreeNode<T> curr;

        public TreePreOrderIterator() {
            stack=new Stack<>();
            curr=T36PreOrderIterator.this.root;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty()||curr!=null;
        }

        @Override
        public T next() {
            T val=curr.val;
            if(curr!=null){
                if(curr.left!=null){/*如果当前结点的左子树不为空,则遍历左子树,并标记当前结点未遍历右子树*/
                    stack.push(curr);//遍历左子树，遍历过的节点入栈
                    curr=curr.left;
                }else if(curr.right!=null){//如果当前结点的左子树为空,则遍历右子树
                    curr=curr.right;
                }else {  /*如果当前结点为叶子,则找未遍历右子树的结点并且遍历它的右子树*/
                    if(!stack.isEmpty()){
                        TreeNode<T> temp=stack.pop();
                        while ((temp.right==null)&&!stack.isEmpty()){//左子树都遍历过了，所以从右子树开始。
                            temp=stack.pop();
                        }
                        curr=temp.right;
                    }else {
                        curr=null;
                    }

                }
            }
            return val;
        }
    }
}
