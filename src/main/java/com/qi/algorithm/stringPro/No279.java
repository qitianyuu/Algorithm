package com.qi.algorithm.stringPro;

/**
 * Description: Perfect Squares 完全平方数
 *
 * 思路：数学可证明任何一个数都可以由4个数的完全平方表示
 *      因此本题最大为4，考虑动态规划，dp[i] 表示 i 的答案，可以得出
 *      dp[i] = 1 + min(dp[i - k*k]) 其中 k 在 [1,√i] 区间内
 *
 * Author: Qi
 * Date: 11-14-2021
 */
public class No279 {

    public int numSquares(int n) {
        if (n == 1)return 1;
        if (n == 2)return 2;
        int[]dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = 5, c = 0;
            for (int j = 1; j * j <= i; j++) {
                c = 1 + dp[i - j * j];
                tmp = Math.min(tmp, c);
            }
            dp[i] = tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No279 no279 = new No279();
        System.out.println(no279.numSquares(12));
    }
}
