package com.qi.algorithm.stringPro;

/**
 * Description: Target Sum 目标和
 *
 * 思路：本题可以用回溯法，但是时间太长，转化为 0-1 背包问题
 *      如何转换？
 *      在一堆数里面挑一个字串，使得字串的和为固定值
 *      如果字串必须连续，则用前缀和，维护一个 Hash 表
 *      如果字串元素任意选，则用背包问题，维护二维数组 dp[][]，使得目标值为列数，数组内元素值为行数
 *      dp[i][j] 代表目标为 j 的时候，有多少种选择方法使得前 i 个元素和为 j
 *
 * Author: Qi
 * Date: 10-26-2021
 */
public class No494_ {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 == 1) return 0;
        int neg = (sum - target) / 2;
        int[][] dp = new int[nums.length+1][neg+1];
        dp[0][0] = 1;
        for (int i = 1; i < nums.length+1; i++) {
            int num = nums[i-1];
            for (int j = 0; j < neg + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= num){
                    dp[i][j] += dp[i-1][j-num];
                }
            }
        }
        return dp[nums.length][neg];
    }


    public static void main(String[] args) {
        No494_ no494_ = new No494_();
        int ans = no494_.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
        System.out.println(ans);
    }
}
