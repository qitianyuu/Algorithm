package com.qi.algorithm.stringPro;

/**
 * Description: Maximal Square 最大正方形
 *
 * 思路：典型的动态规划问题，先搞明白，如果此格子是1，那么此格子作为右下角的最大张方形为左、上、左上三个格子的最小值加一。
 *      如果为零，则就为一。一次遍历，找到最大的值，返回平方(面积)
 *
 * Author: Qi
 * Date: 09-29-2021
 */
public class No221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][]dp = new int[m][n];
        int max = 0;
        dp[0][0] = matrix[0][0] == '1'?1:0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else {
                    int tmp = Math.min(dp[i-1][j], dp[i][j-1]);
                    dp[i][j] = Math.min(tmp, dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        No221 no221 = new No221();
        int i = no221.maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        System.out.println(i);
    }

}
