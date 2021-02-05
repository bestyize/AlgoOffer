package thewind.leetcode.p1;

import org.junit.Test;
import thewind.util.PrintHelper;


public class T26DeleteDupItem {
    @Test
    public void test(){
        PrintHelper.print(removeDuplicates(new int[]{1,1,1,1}));
    }

    public int removeDuplicates(int[] nums) {
        int slow=0;
        int quick=1;
        while (quick<nums.length){
            while (quick<nums.length&&nums[quick]==nums[slow]){
                quick++;
            }
            if(quick<nums.length){
                nums[++slow]=nums[quick++];
            }
        }
        return slow+1;
    }
}
