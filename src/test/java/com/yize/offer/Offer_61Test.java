package com.yize.offer;

import com.yize.datastructure.TreeNode;
import org.junit.Test;


public class Offer_61Test {
    @Test
    public void test(){
        TreeNode root=new TreeNode(0);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        root.left=node1;
        root.right=node2;
        node1.left=node3;
        node2.right=node4;



    }
    @Test
    public void deTest(){

    }
}
