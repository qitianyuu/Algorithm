package com.qi.algorithm.stringPro;

/**
 * Description: Unique Binary Search Trees 不同的二叉搜索树
 *
 * 思路：针对每个给定的序列长度 n，可以循环分别以 n 个不同的点作为根节点
 *      0～i-1，i+1～n 分别作为左右子树，因此可以得到子问题，应用动态规划解决。
 *
 * Author: Qi
 * Date: 10-10-2021
 */
public class No96 {

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i -j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
