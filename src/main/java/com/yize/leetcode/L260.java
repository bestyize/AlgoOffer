package com.yize.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 *
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 * 注意：
 *
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L260 {
    public int[] singleNumber(int[] nums){
        int result=0;
        for (int num:nums){
            result^=num;
        }
        int a=0;
        int b=0;
        for (int i=31;i>=0;i--){
            int temp;
            if((temp=result&(1<<i))!=0){//找到最高位
                for (int num:nums){
                    if((num&temp)==0){
                        a^=num;
                    }else {
                        b^=num;
                    }
                }
                break;
            }
        }
        return new int[]{a,b};
    }

    public int[] singleNumber1(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,2);
            }else{
                map.put(num,1);
            }
        }
        int[] result=new int[2];
        int ptr=0;
        for(Integer i:map.keySet()){
            if(map.get(i)==1){
                result[ptr++]=i;
            }
        }
        return result;
    }
}
