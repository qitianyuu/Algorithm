package com.qi.algorithm.stringPro;

/**
 * Description: Guess Number Higher or Lower II 猜数字大小 II
 *
 * 思路：假设 dp[i][j] 表示 i 到 j 的 cost，则可以分解成 dp[i][j] = k + dp[i][k-1] + dp[k+1][j]
 *      k 在 [i,j] 中取值，且 dp[i][i+1] = i， 因此通过步长为一的可以求得步长为2的，依此循环
 *      其中 d 为步长
 *
 * Author: Qi
 * Date: 11-12-2021
 */
public class No375 {

    public int getMoneyAmount(int n) {
        int[][]dp = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            dp[i][i+1] = i;
        }
        for (int d = 2; d < n; d++) {
            for (int i = 1; i + d <= n; i++) {
                int j = i + d;
                int minCost = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    minCost = Math.min(minCost, cost);
                }
                dp[i][j] = minCost;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        No375 no375 = new No375();
        System.out.println(no375.getMoneyAmount(10));
    }
}
