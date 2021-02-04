package thewind.bytedance;

public class T7QuickSort {
    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums,int low,int high){
        if(low<high){
            int i=low,j=high;
            int pivot=nums[low];
            while (i<j){
                while (i<j&&nums[j]>=pivot){//找右边第一个小于枢纽元的值
                    j--;
                }
                while (i<j&&nums[i]<=pivot){//找左边第一个大于枢纽元的值
                    i++;
                }
                if(i<j){
                    swap(nums,i,j);
                }
            }
            swap(nums,low,i);//恢复枢纽元
            quickSort(nums,low,i-1);
            quickSort(nums,i+1,high);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
