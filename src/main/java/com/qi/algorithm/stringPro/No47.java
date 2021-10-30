package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Permutations II 全排列 II
 *
 * 思路：本题采用回溯法，首先从根结点开始回溯，设置 visited 来表示是否被访问过。
 *
 * Author: Qi
 * Date: 10-28-2021
 */
public class No47 {

    boolean [] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, ans, 0, perm);
        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, int index, List<Integer> perm) {
        if (index == nums.length){
            ans.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])){
                continue;
            }
            perm.add(nums[i]);
            visited[i] = true;
            dfs(nums, ans, index + 1, perm);
            visited[i] = false;
            perm.remove(index);
        }
    }

    public static void main(String[] args) {
        No47 no47 = new No47();
        System.out.println(no47.permuteUnique(new int[]{1, 1, 2}));
    }
}
