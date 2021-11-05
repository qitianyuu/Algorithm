package com.qi.algorithm.stringPro;

/**
 * Description: 2 Keys Keyboard 只有两个键的键盘
 *
 * 思路：动态规划，i 个长度可以由能整除 i 的 j 得来，步数为 1 + dp[j] + i/j - 1
 *
 * Author: Qi
 * Date: 11-05-2021
 */
public class No650 {

    public int minSteps(int n) {
        int[]dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (i % j == 0){
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No650 no650 = new No650();
        System.out.println(no650.minSteps(8));
    }
}
