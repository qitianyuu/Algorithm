package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Increasing Subsequences 递增子序列
 *
 * 思路：所有列举所有可能的都可以用回溯法，
 *      本题类似。
 *
 * Author: Qi
 * Date: 09-18-2021
 */
public class No497 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        trackback(ans, tmp, nums, 0);
        return ans;

        //------
        //dfs(ans, tmp, 0, Integer.MIN_VALUE, nums);
        //return ans;
    }

    private void trackback(List<List<Integer>> ans, List<Integer> tmp, int[] nums, int index) {
        if (index == nums.length){
            if (tmp.size() >= 2 && !ans.contains(tmp)){
                ans.add(new ArrayList<>(tmp));
            }
            return;
        }
        if (tmp.size() == 0 || (tmp.size() > 0 && tmp.get(tmp.size()-1) <= nums[index])){
            tmp.add(nums[index]);
            trackback(ans, tmp, nums, index + 1);
            tmp.remove(tmp.size() - 1);
        }
        trackback(ans, tmp, nums, index + 1);
    }


    private void dfs(List<List<Integer>> ans, List<Integer> tmp, int index, int last, int[] nums) {
        if (index == nums.length) {
            if (tmp.size() >= 2) {
                ans.add(new ArrayList<Integer>(tmp));
            }
            return;
        }
        if (nums[index] >= last) {
            tmp.add(nums[index]);
            dfs(ans, tmp, index + 1, nums[index], nums);
            tmp.remove(tmp.size() - 1);
        }
        if (nums[index] != last) {
            dfs(ans, tmp, index + 1, last, nums);
        }
    }

    public static void main(String[] args) {
        No497 no497 = new No497();
        List<List<Integer>> ans = no497.findSubsequences(new int[]{4,6,7,7});
        System.out.println(ans.toString());
    }
}
