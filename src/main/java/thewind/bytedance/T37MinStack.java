package thewind.bytedance;

import org.junit.Test;

import java.util.Stack;

public class T37MinStack {

    @Test
    public void test(){
        MinStack stack=new MinStack();
        int nums[]={4,2,1,1,15,6};
        for (int n:nums){
            stack.push(n);
        }
        while (!stack.isEmpty()){
            System.out.println(stack.peekMin()+" "+stack.pop());
        }
    }

    private class MinStack{
        int size=0;
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> minStack=new Stack<>();
        public void push(int i){
            stack.push(i);
            size++;
            if(minStack.isEmpty()){
                minStack.push(i);
            }else {
                if(minStack.peek()>=i){
                    minStack.push(i);
                }
            }
        }

        public int pop(){
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            int val=stack.pop();
            if(val==minStack.peek()){
                minStack.pop();
            }
            size--;
            return val;
        }

        public int peekMin(){
            return minStack.peek();
        }

        public boolean isEmpty(){
            return size==0;
        }
    }
}
