package thewind.high;

public class MergerSort {
    public void mergeSort(int[] nums){
        mergeSort(nums,0,nums.length-1);
    }

    public void mergeSort(int[] nums,int low,int high){
        if(low<high){
            int mid=(low+high)>>1;
            mergeSort(nums,low,mid);
            mergeSort(nums,mid+1,high);
            merge(nums,low,mid,high);
        }
    }

    public void merge(int[] nums,int low,int mid,int high){
        int i=low,j=mid+1;
        int[] temp=new int[high-low+1];
        int curr=0;
        while (i<=mid&&j<=high){
            if(nums[i]<=nums[j]){
                temp[curr++]=nums[j];
            }else {
                temp[curr++]=nums[i];
            }
        }
        while (i<=mid){
            temp[curr++]=nums[i++];
        }
        while (j<=mid){
            temp[curr++]=nums[j++];
        }
        for (int k=low;k<=high;k++){
            nums[k]=temp[k-low];
        }

    }
}
