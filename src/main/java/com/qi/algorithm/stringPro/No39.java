package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Combination Sum 组合总和
 *
 * 思路：对于这类寻找所有可行解的题，我们都可以尝试用「搜索回溯」的方法来解决。
 *      建立树，每层都是根节点的下一步的各种取值。
 *      然后按照要求进行递归。
 *
 * Author: Qi
 * Date: 09-13-2021
 */
public class No39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        trackback(ans, candidates, target, cur, 0, 0);
        return ans;
    }

    private void trackback(List<List<Integer>> ans, int[] candidates, int target, List<Integer> cur, int index, int sum) {
        if (sum == target){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int curSum = sum + candidates[i];
            if (curSum <= target){
                cur.add(candidates[i]);
                trackback(ans, candidates, target, cur, i, curSum);
                cur.remove(cur.size()-1);
            }
            else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        No39 no39 = new No39();
        List<List<Integer>> lists = no39.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists.toString());
    }
}
