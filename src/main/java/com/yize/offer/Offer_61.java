package com.yize.offer;

import com.yize.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer_61 {

    /**
     * 前序遍历序列化
     * @param root
     * @return
     */
    public static String Serialize(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<String> list=new ArrayList<String>();
        TreeNode pNode=root;
        while (pNode!=null||stack.isEmpty()==false){
            if(pNode!=null){
                list.add(pNode.val+"!");

                stack.push(pNode);
                pNode=pNode.left;
            }else {

                list.add("#!");
                pNode=stack.pop();
                pNode=pNode.right;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (String s:list){
            sb.append(s);
        }
        return sb.toString();

    }
    public TreeNode Deserialize(String str) {
        str=str.replaceAll("#","#!");
        String values[]=str.split("!");

        int rootVal=Integer.valueOf(str.substring(0,str.indexOf("!")));
        TreeNode rootNode=new TreeNode(rootVal);

        return null;
    }


    public String SerializeClone(TreeNode root){
        StringBuilder sb=new StringBuilder();
        if(root!=null){
            sb.append(root.val+"!");
            sb.append(SerializeClone(root.left));
            sb.append(SerializeClone(root.right));
        }else {
            sb.append("#!");
            return sb.toString();
        }
        return sb.toString();

    }

    private int decIndex=-1;
    public TreeNode DeserializeClone(String str) {
        decIndex++;
        String[] ss=str.split("!");
        TreeNode node=null;
        if(!ss[decIndex].equals("#")){
            node=new TreeNode(Integer.valueOf(ss[decIndex]));
            node.left=DeserializeClone(str);
            node.right=DeserializeClone(str);
        }
        return node;
    }

}
