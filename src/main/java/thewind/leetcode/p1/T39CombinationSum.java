package thewind.leetcode.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 *
 * 提示：
 *
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class T39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list=new ArrayList<>();
        backTrack(list,new ArrayList<>(),candidates,target,0);
        return list;
    }

    public void backTrack(List<List<Integer>> list,List<Integer> currList,int[] nums,int target,int startPos){
        if(target<0){
            return;
        }
        if(target==0){
            list.add(new ArrayList<>(currList));
            return;
        }
        for (int i=startPos;i< nums.length&&nums[i]<=target;i++){//剪枝
            currList.add(nums[i]);
            backTrack(list,currList,nums,target-nums[i],i);
            currList.remove(currList.size()-1);
        }
    }
}
