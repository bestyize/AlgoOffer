package com.yize.algo.chapter04;

import java.nio.BufferUnderflowException;

public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T>{
        BinaryNode<T> left;
        BinaryNode<T> right;
        T element;

        public BinaryNode(BinaryNode<T> left, BinaryNode<T> right, T element) {
            this.left = left;
            this.right = right;
            this.element = element;
        }
    }
    private BinaryNode<T> root;
    public BinarySearchTree(){
        root=null;
    }
    public void makeEmpty(){
        root=null;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean contains(T t){
        return contains(root,t);
    }

    public T findMin(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        return findMin(root).element;
    }

    public T findMax(){
        if(isEmpty()){
            throw new BufferUnderflowException();
        }
        return findMax(root).element;
    }

    public void insert(T t){
        root=insert(root,t);
    }

    public void remove(T t){
        root=remove(root,t);
    }


    private boolean contains(BinaryNode<T> x,T t){
        if(isEmpty()){
            return false;
        }
        int result= x.element.compareTo(t);
        if(result>0){
            return contains(x.left,t);
        }else if(result<0){
            return contains(x.right,t);
        }else {
            return true;
        }
    }

    private BinaryNode<T> findMin(BinaryNode<T> x){
        if(x==null){
            return null;
        }
        if(x.left==null){
            return x;
        }
        return findMin(x.left);
    }

    private BinaryNode<T> findMax(BinaryNode<T> x){
        if(x==null){
            return null;
        }
        if(x.right==null){
            return x;
        }
        return findMax(x.right);
    }

    private BinaryNode<T> insert(BinaryNode<T> x,T t){
        if(x==null){
            return new BinaryNode<T>(null,null,t);
        }
        int compareResult=x.element.compareTo(t);
        if(compareResult>0){
            x.left=insert(x.left,t);
        }else if(compareResult<0) {
            x.right = insert(x.right, t);
        }
        return x;
    }

    private BinaryNode<T> remove(BinaryNode<T> node,T t){
        if(node==null){
            return node;
        }
        int result=node.element.compareTo(t);
        if(result>0){
            node.left=remove(node.left,t);
        }else if(result>0){
            node.right=remove(node.right,t);
        }else {
            if(node.left!=null&&node.right!=null){
                node.element=findMin(node.right).element;
                node.right=remove(node.right,node.element);
            }else{
                node=(node.left==null)?node.right:node.left;
            }
        }
        return node;
    }

}
