package com.qi.algorithm.stringPro;

/**
 * Description: Jump Game II 跳跃游戏 II
 *
 * 思路：本题采用动态规划，每次向后更新能跳的最大步数个元素，并保留最小的跳跃次数，直至结尾。
 *
 * Author: Qi
 * Date: 11-04-2021
 */
public class No45 {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j == n)break;
                if (dp[i+j] == 0) dp[i+j] = dp[i] + 1;
                else{
                    dp[i+j] = Math.min(dp[i+j], dp[i]+1);
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        No45 no45 = new No45();
        System.out.println(no45.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
