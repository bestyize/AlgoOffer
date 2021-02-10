package thewind.bdtest;

import com.yize.algo.chapter07.PrinterHelper;
import org.junit.Test;

public class T7QuickSort {

    @Test
    public void test(){
        int[] nums={4,10,1,89,5,2,7};
        quickSort(nums);
        PrinterHelper.print(nums);
    }

    public void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums,int low,int high){
        if(low<high){
            int i=low,j=high;
            int pivot=nums[i];
            while (i<j){
                while (i<j&&nums[j]>=pivot){
                    j--;
                }
                while (i<j&&nums[i]<=pivot){
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

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
