package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Combination Sum II 组合总和 II
 *
 * 思路：和 No39 类似，只是需要加一个小剪枝，即当后一个和前一个相同时，忽略。
 *
 * Author: Qi
 * Date: 09-13-2021
 */
public class No40 {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        trackback(ans, cur, candidates, target, -1, 0);
        return ans;
    }

    private void trackback(List<List<Integer>> ans, List<Integer> cur, int[] candidates, int target, int index, int sum) {
        if (sum == target){
            if (!ans.contains(cur)){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = index + 1; i < candidates.length; i++) {
            int curSum = candidates[i] + sum;
            if (i > index + 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (curSum <= target){
                cur.add(candidates[i]);
                trackback(ans, cur, candidates, target, i, curSum);
                cur.remove(cur.size() - 1);
            }else break;
        }
    }

    public static void main(String[] args) {
        No40 no40 = new No40();
        List<List<Integer>> lists = no40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(lists.toString());
    }
}
