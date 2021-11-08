package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Combination Sum III 组合总和 III
 *
 * 思路：回溯法，迭代判断选还是不选这个数，最终达到给定的个数后看是否满足条件。
 *
 * Author: Qi
 * Date: 11-07-2021
 */
public class No216 {

    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        dfs(k, n, 0, new ArrayList<Integer>(), 1, 0);
        return ans;
    }

    private void dfs(int k, int n, int sum, ArrayList<Integer> list, int index, int num) {
        if (index == 10 || num == k){
            if (n == sum && num == k){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (num < k && sum <= n){
            list.add(index);
            dfs(k, n, sum+index, list, index+1, num+1);
            list.remove(Integer.valueOf(index));
            dfs(k, n, sum, list, index+1, num);
        }
    }

    public static void main(String[] args) {
        No216 no216 = new No216();
        List<List<Integer>> lists = no216.combinationSum3(3, 9);
        lists.forEach(item -> {
            System.out.println(Arrays.toString(item.toArray()));
        });
    }
}
