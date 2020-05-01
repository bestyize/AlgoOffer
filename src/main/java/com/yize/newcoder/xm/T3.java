package com.yize.newcoder.xm;

import com.yize.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T3 {
    public static void main(String[] args) {

    }

    public TreeNode rebuild(TreeNode node){
        if(node==null||(node.left==null&&node.right==null)){
            return node;
        }
        List<TreeNode> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(node!=null||stack.isEmpty()==false){
            if(node!=null){
                list.add(node);
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                node=node.right;
            }
        }
        TreeNode leftNode=null;
        for (int i=0;i<list.size();i++){
            TreeNode temp=list.get(i);
            temp.left=leftNode;
            if(i==list.size()-1){
                temp.right=null;
            }else {
                temp.right=list.get(i+1);
            }

            leftNode=temp;
        }
        return list.get(0);
    }


}
