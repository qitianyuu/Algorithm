package com.qi.algorithm.stringPro;

/**
 * Description: Longest Increasing Subsequence 最长递增子序列
 *
 * 思路：动态规划，考虑状态转移方程的时候，不一定是只和前一个元素相关，有可能还和前面所有的元素相关。
 *
 * Author: Qi
 * Date: 10-15-2021
 */
public class No300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        No300 no300 = new No300();
        System.out.println(no300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
}
