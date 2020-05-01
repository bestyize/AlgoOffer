package com.yize.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L137 {
    //将每个数想象成32位的二进制，对于每一位的二进制的1和0累加起来必然是3N或者3N+1，
    // 为3N代表目标值在这一位没贡献，3N+1代表目标值在这一位有贡献(=1)，
    // 然后将所有有贡献的位|起来就是结果。这样做的好处是如果题目改成K个一样，
    // 只需要把代码改成cnt%k，很通用
    public int singleNumber(int[] nums) {
        int ret=0;
        for (int i=0;i<32;i++){
            int mask=1<<i;
            int oneCount=0;
            for (int n:nums){
                if((n&mask)!=0){
                    oneCount++;
                }
            }
            if(oneCount%3!=0){
                ret|=mask;
            }
        }
        return ret;
    }

    public int singleNumber1(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }

        for(int i:map.keySet()){
            if(map.get(i)==1){
                return i;
            }
        }
        return -1;
    }
}
