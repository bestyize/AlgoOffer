package thewind.bytedance;

import java.util.Stack;

/**
 * 右边第一个大于当前元素的元素
 */
public class T25RightBiggerValue {
    public int[] rightBigger(int[] nums){
        int len=nums.length;
        int[] res=new int[len];
        int curr=1;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        while (curr<len){
            if(!stack.isEmpty()&&nums[curr]>nums[stack.peek()]){
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
