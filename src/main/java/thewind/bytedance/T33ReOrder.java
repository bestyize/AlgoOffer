package thewind.bytedance;

/**
 * https://blog.csdn.net/qq_23594799/article/details/105266758
 *
 * 给定一个数组，将奇数（正数…etc）排在左边，偶数排在右边（保证相对位置不变）
 */
public class T33ReOrder {
    public void reOrder(int[] nums){
        int ptr=0;
        for (int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                int curr=i;
                while (curr>ptr){
                    swap(nums,curr,--curr);
                }
                ptr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
