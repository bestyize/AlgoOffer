package thewind.leetcode.p1;

import java.util.ArrayList;
import java.util.List;

public class T46FullPermute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backTrack(list,new ArrayList<>(),nums);
        return list;
    }

    private void backTrack(List<List<Integer>> list,List<Integer> item,int[] nums){
        if(item.size()== nums.length){
            list.add(new ArrayList<>(item));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if(item.contains(nums[i])){
                continue;
            }
            item.add(nums[i]);
            backTrack(list,item,nums);
            item.remove(item.size()-1);
        }
    }

}
