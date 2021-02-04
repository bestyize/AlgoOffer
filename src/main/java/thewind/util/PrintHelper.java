package thewind.util;

public class PrintHelper {
    public static void print(int[] nums){
        for (int i:nums){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void print(int[] nums,int range){
        for (int i=0;i<range;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void print(int num){
        System.out.println(num);
    }

}
