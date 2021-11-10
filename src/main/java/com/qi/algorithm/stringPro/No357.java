package com.qi.algorithm.stringPro;

/**
 * Description: Count Numbers with Unique Digits 计算各个位数不同的数字个数
 *
 * 思路：用 a 记录之前的所有结果，dp[i] 为 i 位的不同结果，最后答案是 a+dp[i]
 *      dp[i] = dp[i-1]*(10 -(i-1)) 因为前面 i-1 位不同的数字，所以后面只有 (10 -(i-1)) 种数字。
 *
 * Author: Qi
 * Date: 11-10-2021
 */
public class No357 {

    public int countNumbersWithUniqueDigits(int n) {
        int[]dp = new int[n+1];
        if (n == 0)return 1;
        dp[0] = 1;
        dp[1] = 9;
        int a = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]*(11-i);
            a += dp[i-1];
        }
        return a + dp[n];
    }

    public static void main(String[] args) {
        No357 no357 = new No357();
        System.out.println(no357.countNumbersWithUniqueDigits(3));
    }
}
