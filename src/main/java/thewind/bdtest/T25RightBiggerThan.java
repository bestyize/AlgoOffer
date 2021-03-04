package thewind.bdtest;

import java.util.Stack;
// 1 3 2 4 5 1 2
public class T25RightBiggerThan {
    public int[] rightBiggerThan(int[] nums){
        int[] res=new int[nums.length];
        Stack<Integer> stack=new Stack<>();//存储索引
        stack.push(0);//没找到右边第一大元素的索引先入栈，本质上是维持了一个左值单调栈，单调栈的上限是未来右边第一大值
        int curr=1;
        while (curr<nums.length){
            if(!stack.isEmpty()&&nums[stack.peek()]<nums[curr]){//当前值小于stack峰顶数
                res[stack.pop()]=nums[curr];//找到了后出栈
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
