package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Combinations 组合
 *
 * 思路：对于这种组合问题，优先考虑回溯算法，限制条件就是剪枝策略
 *
 * Author: Qi
 * Date: 09-14-2021
 */
public class No77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        trackback(ans, cur, n, k, 1,1);
        return ans;
    }

    private void trackback(List<List<Integer>> ans, List<Integer> cur, int n, int k, int index, int now) {
        if (index == k + 1){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = now; i < n + 1; i++) {
            if (!cur.contains(i)){
                cur.add(i);
                trackback(ans, cur, n, k, index + 1, i);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        No77 no77 = new No77();
        List<List<Integer>> combine = no77.combine(4, 2);
        combine.forEach(item -> {
            System.out.println(item.toString());
        });
    }

}
