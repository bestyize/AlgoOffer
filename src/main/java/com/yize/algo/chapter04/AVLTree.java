package com.yize.algo.chapter04;

import java.util.Map;

public class AVLTree<T extends Comparable<? super T>> {
    private static final int ALLOWED_BALANCE=1;
    private static class AVLNode<T>{
        AVLNode<T> left;
        AVLNode<T> right;
        T element;
        int height;

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T element) {
            this.left = left;
            this.right = right;
            this.element = element;
        }

        public AVLNode(AVLNode<T> left, AVLNode<T> right, T element, int height) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.height = height;
        }
    }

    /**
     * 计算AVL节点高度
     * @param node
     * @return
     */
    private int height(AVLNode<T> node){
        return node==null?-1:node.height;
    }

    private AVLNode<T> insert(AVLNode<T> node,T x){
        if(node==null){
            return new AVLNode<>(null,null,x);
        }
        int result=node.element.compareTo(x);
        if(result>0){
            node.left=insert(node.left,x);
        }else if(result<0){
            node.right=insert(node.right,x);
        }
        return balance(node);
    }

    private AVLNode<T> remove(AVLNode<T> node,T x){
        if(node==null){
            return node;
        }
        int result=node.element.compareTo(x);
        if(result>0){
            node.left=remove(node,x);
        }else if(result<0){
            node.right=remove(node.right,x);
        }else {
            if(node.left!=null&&node.right!=null){
                node.element=findMin(node.right).element;
                node.right=remove(node.right,node.element);
            }else {
                node=(node.left==null)?node.left:node.right;
            }
        }
        return balance(node);
    }

    private AVLNode<T> findMin(AVLNode<T> node){
        if(node==null){
            return node;
        }
        if(node.left==null){
            return node;
        }
        return findMin(node.left);
    }

    /**
     * 进行平衡
     * @param node
     * @return
     */
    private AVLNode<T> balance(AVLNode<T> node) {
        if(node==null){
            return node;
        }
        if(height(node.left)-height(node.right)>ALLOWED_BALANCE){
            if(height(node.left.left)>=height(node.left.right)){
                node=rotateWithLeftChild(node);
            }else {
                node=doubleWithLeftChild(node);
            }
        }else if(height(node.right)-height(node.left)>ALLOWED_BALANCE){
            if(height(node.right.right)>=height(node.right.left)){
                node=rotateWithRightChild(node);
            }else {
                node=doubleWithRightChild(node);
            }
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }

    private AVLNode<T> rotateWithLeftChild(AVLNode<T> k2) {
        AVLNode<T> k1=k2.left;
        k2.left=k1.right;
        k1.right=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height=Math.max(height(k1.left),k2.height)+1;
        return k1;
    }
    private AVLNode<T> doubleWithLeftChild(AVLNode<T> k3) {
        k3.left=rotateWithRightChild(k3.right);
        return rotateWithLeftChild(k3);
    }
    private AVLNode<T> rotateWithRightChild(AVLNode<T> k2) {
        AVLNode<T> k1=k2.right;
        k2.right=k1.left;
        k1.left=k2;
        k2.height=Math.max(height(k2.left),height(k2.right))+1;
        k1.height= Math.max(height(k1.right),k2.height)+1;
        return k1;
    }
    private AVLNode<T> doubleWithRightChild(AVLNode<T> k3) {
        k3.right=rotateWithLeftChild(k3.left);
        return rotateWithRightChild(k3);
    }
}
