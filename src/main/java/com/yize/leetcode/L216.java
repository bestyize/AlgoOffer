package com.yize.leetcode;
import java.util.ArrayList;
import java.util.List;
/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results=new ArrayList<>();
        backTrack(k,n,1,results,new ArrayList<>());
        return results;
    }

    public void backTrack(int k,int n,int start,List<List<Integer>> results,List<Integer> path){
        if(k==path.size()&&n==0){
            results.add(new ArrayList<>(path));
        }else if(k==path.size()||n<=0){
            return;
        }else {
            for (int i=start;i<=9&&n-i>=0;i++){
                path.add(i);
                backTrack(k,n-i,i+1,results,path);
                path.remove(path.size()-1);
            }
        }
    }
}
