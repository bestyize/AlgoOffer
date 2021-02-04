package thewind.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找数组中承上启下的元素，左边的元素小于它，右边的元素大于它
 *
 * 本质上是找左边最大元素，以及右边最大元素，是单调栈问题的一种变形
 */
public class T28FindBridgeNumber {
    public void findBridgeNumber(int[] nums){
        List<Integer> list=new ArrayList<>();
        if(nums.length<=2){
            return;
        }

        int[] dpLeft=new int[nums.length];
        dpLeft[0]=Integer.MIN_VALUE;
        dpLeft[1]=nums[0];
        for (int i=2;i<dpLeft.length;i++){
            dpLeft[i]=Math.max(dpLeft[i-1],nums[i-1]);
        }

        int[] dpRight=new int[nums.length];
        dpRight[nums.length-1]=Integer.MIN_VALUE;
        dpRight[nums.length-2]=nums[nums.length-1];

        for (int i=dpRight.length-3;i>=0;i--){
            dpRight[i]=Math.max(dpRight[i+1],nums[i+1]);
        }

        for (int i=0;i<dpLeft.length;i++){
            if(dpLeft[i]<nums[i]&&nums[i]<dpRight[i]){
                list.add(nums[i]);
            }
        }
    }
}
