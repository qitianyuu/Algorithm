package com.qi.algorithm.stringPro;

/**
 * Description: Partition Equal Subset Sum 分割等和子集
 *
 * 思路：0-1背包问题，传统背包问题解决的是背包容量固定时最多装多少东西问题
 *      现在此问题可以理解为 是否能找到子集使得子集的和为总合的一半的问题
 *      即背包容量为 sum/2。共有 n 行，dp 矩阵为是否可达的布尔值
 *
 * Author: Qi
 * Date: 10-24-2021
 */
public class No416 {

    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (n < 2 || sum % 2 == 1)return false;
        int target = sum / 2;
        if (target < max) return false;
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        dp[0][nums[0]] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (nums[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target] != 0;
    }

    public static void main(String[] args) {
        No416 no416 = new No416();
        System.out.println(no416.canPartition(new int[]{1, 2, 3, 5}));
    }
}
