package com.qi.algorithm.stringPro;

/**
 * Description: Edit Distance 编辑距离
 * Author: Qi
 * Date: 09-30-2021
 */
public class No72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m * n == 0)return m+n;
        // 创建并初始化
        int [][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int tmp = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)){
                    tmp--;
                }
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), tmp) + 1;
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        No72 no72 = new No72();
        int i = no72.minDistance("horse", "ros");
        System.out.println(i);
    }
}
