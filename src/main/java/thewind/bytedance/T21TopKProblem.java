package thewind.bytedance;

import org.junit.Test;

import java.util.PriorityQueue;

public class T21TopKProblem {

    @Test
    public void test(){
        int[] nums={1,2,3,4,5,6,8,11};
        //findTopKValue(nums,nums.length);
        findKthVal(nums,1);
        System.out.println();
        PriorityQueue<Integer> heap=new PriorityQueue<>((o1, o2) -> o2-o1);

    }


    /**
     * 用堆实现TopK,寻找最大的K个元素
     * @param nums
     * @param k
     */
    public void findTopKValue(int[] nums,int k){
        if(nums.length<k){
            return;
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for (int i=0;i<nums.length;i++){
            if(heap.size()<k){
                heap.offer(nums[i]);
            }else if(heap.peek()<nums[i]) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        while (!heap.isEmpty()){
            System.out.print(heap.poll()+" ");
        }
        System.out.println();
    }

    public void findKthVal(int[] nums,int k){
        if(nums.length<k){
            return;
        }
        quickSelect(nums,0,nums.length-1,k);
        System.out.println(nums[k-1]);
    }

    /**
     * 快速选择
     * @param nums
     * @param low
     * @param high
     * @param k
     */
    public void quickSelect(int[] nums,int low,int high,int k){
        if(low<high){
            int i=low,j=high;
            int pivot=nums[low];
            while (i<j){
                while (i<j&&nums[j]<=pivot){//从右向左，找到第一个大于pivot的值
                    j--;
                }
                while (i<j&&nums[i]>=pivot){//从左向右，找到第一个小于pivot的值
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,low,i);//恢复枢纽元
            if(i>=k){
                quickSelect(nums,low,i-1,k);
            }else {
                quickSelect(nums,i+1,high,k);
            }

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     * 一次快速选择，如果是偶数，那么选到中间偏后一个位置，
     * 此时，在前面选出第二大元素即可，如果是奇数，那么选择的直接就是中位数
     * @param nums
     */
    public void findMedium(int[] nums){
        int midPos=(nums.length+1)>>1;
        findKthVal(nums,midPos);
        if((nums.length&1)==0){
            int max=Integer.MIN_VALUE;
            for (int i=0;i<midPos-1;i++){
                max=Math.max(nums[i],max);
            }
            System.out.println((max+nums[midPos-1])>>1);
        }else {
            System.out.println(nums[midPos-1]);
        }
    }
}
