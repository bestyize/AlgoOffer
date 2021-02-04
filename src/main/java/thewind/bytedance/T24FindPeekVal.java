package thewind.bytedance;

import org.junit.Test;

/**
 * 1 2 3 2 1
 */
public class T24FindPeekVal {

    @Test
    public void test(){
        int[] nums={7,2,1};
        System.out.println(find(nums));
    }

    /**
     * 先升后降数组拐点
     * @param nums
     * @return
     */
    public int find(int[] nums){
        int low=0,high=nums.length-1;
        while (low<=high){
            int mid=(low+high+1)>>1;
            if(mid==0||mid==nums.length-1||nums[mid-1]<nums[mid]&&nums[mid+1]<nums[mid]){
                return mid;
            }
            if (nums[mid-1]<nums[mid]){
                low=mid;
            }else {
                high=mid-1;
            }

        }
        return -1;
    }
}
