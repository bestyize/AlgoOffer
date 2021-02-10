package thewind.bdtest;

import java.util.Stack;

public class T25RightBiggerThan {
    public int[] rightBiggerThan(int[] nums){
        int[] res=new int[nums.length];
        Stack<Integer> stack=new Stack<>();//存储索引
        stack.push(0);
        int curr=1;
        while (curr<nums.length){
            if(!stack.isEmpty()&&nums[stack.peek()]<nums[curr]){//当前值小于stack峰顶数
                res[stack.pop()]=nums[curr];
            }else {
                stack.push(curr++);
            }
        }
        if(!stack.isEmpty()){
            res[stack.pop()]=-1;
        }
        return res;
    }
}
