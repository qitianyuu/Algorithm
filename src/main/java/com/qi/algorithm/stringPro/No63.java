package com.qi.algorithm.stringPro;

/**
 * Description: Unique Paths II 不同路径 II
 *
 * 思路：动态规划，着重考虑障碍物的 ans矩阵的值如何判断和赋值。
 *
 * Author: Qi
 * Date: 09-15-2021
 */
public class No63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] ans = new int[m][n];
        if (m == 1 && n == 1) return obstacleGrid[0][0] == 1 ? 0 : 1;
        ans[0][0] = 1;
        for (int i = 1; i < m; i++) {
            ans[i][0] = ans[i-1][0] == 0 ||obstacleGrid[i][0] == 1 ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            ans[0][i] = ans[0][i-1] == 0 ||obstacleGrid[0][i] == 1 ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = obstacleGrid[i][j] == 1 ? 0 :ans[i-1][j] + ans[i][j-1];
            }
        }
        return ans[m-1][n-1];
    }

    public static void main(String[] args) {
        No63 no63 = new No63();
        int i = no63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(i);
    }
}
