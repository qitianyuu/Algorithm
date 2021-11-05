package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Longest Arithmetic Subsequence of Given Difference 最长定差子序列
 *
 * 思路：动态规划，第 i 个的长度是第 i-diff 的长度加一
 *
 * Author: Qi
 * Date: 11-05-2021
 */
public class No1218 {

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int item : arr) {
            map.put(item, map.getOrDefault(item-difference, 0)+1);
            ans = Math.max(ans, map.get(item));
        }
        return ans;
    }

    public static void main(String[] args) {
        No1218 no1218 = new No1218();
        System.out.println(no1218.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
    }
}
