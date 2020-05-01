package com.yize.leetcode;
import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class L257 {
    @Test
    public void test(){
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        node1.left=node2;
        node1.right=node3;
        System.out.println(binaryTreePaths(node1));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        helper(root,"");
        return list;
    }
    private List<String> list=new ArrayList<>();
    public void helper(TreeNode node,String path){
        if(node==null){
            return;
        }
        path+=node.val;
        if(node.left==null&&node.right==null){
            list.add(path);
        }else {
            helper(node.left,path+"->");
            helper(node.right,path+"->");
        }
    }
}
