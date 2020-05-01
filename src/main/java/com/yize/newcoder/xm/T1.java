package com.yize.newcoder.xm;

import com.yize.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T1 {
    @Test
    public void test(){

    }

    private List<Integer> helper(TreeNode node){
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.offerFirst(node);
        List<Integer> layerMax=new ArrayList<>();
        while(queue.size()>0){
            int size=queue.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.pollLast();
                max=Math.max(max,curr.val);
                if(curr.left!=null){
                    queue.offerFirst(curr.left);
                }
                if(curr.right!=null){
                    queue.offerLast(curr.right);
                }
            }
            layerMax.add(max);
        }
        return layerMax;
    }
}
