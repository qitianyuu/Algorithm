package com.qi.algorithm.stringPro;

/**
 * Description: House Robber 打家劫舍
 *
 * 思路：经典动态规划问题，抢劫第 k 家与否，需要判断前 k-2 与 k 的和和 k-1 相比谁更多
 *      所以先算出 0、1家的值，往后依次遍历，最后得到 n 家就是结果。
 *
 * Author: Qi
 * Date: 09-29-2021
 */
public class No198 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }
        if (n == 1)return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[n-1];

    }

    public static void main(String[] args) {
        No198 no198 = new No198();
        int rob = no198.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);
    }
}
