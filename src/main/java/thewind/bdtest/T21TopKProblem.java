package thewind.bdtest;

import java.util.PriorityQueue;

public class T21TopKProblem {
    /**
     * 寻找第K大的数
     * @param nums
     * @param k
     */
    public void findTopKUseHeap(int[]nums,int k){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for (int n:nums){
            if(heap.size()<k){
                heap.offer(n);
            }else {
                if(heap.peek()<n){
                    heap.poll();
                    heap.offer(n);
                }
            }
        }
        System.out.println(heap.peek());
    }

    public void findMediumNum(int[] nums){
        int k=(nums.length+1)>>1;
        int val=findTopKUseQuickSelect(nums,k);
        if((nums.length&1)!=0){
            System.out.println(val);
        }else {
            int k1=nums[0];
            for (int i=1;i<k-1;i++){
                k1=Math.max(k1,nums[i]);
            }
            System.out.println((val+k1)>>1);
        }
    }

    public int findTopKUseQuickSelect(int[] nums,int k){
        if(k>=nums.length){
            return -1;
        }
        quickSelect(nums,0,nums.length-1,k);
        return nums[k-1];
    }

    private void quickSelect(int[] nums,int low,int high,int k){
        if(low<high){
            int i=low,j=high;
            int pivot=nums[low];
            while (i<j){
                while (i<j&&nums[j]<=pivot){
                    j--;
                }
                while (i<j&&nums[i]>=pivot){
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,low,i);
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
}
