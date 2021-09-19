package com.qi.algorithm.stringPro;

/**
 * Description: Minimum Path Sum 最小路径和
 *
 * 思路：动态规划，划分子问题，第 i, j 点的最小值就是 i, j 的值加上 min(左边,上面) 这样就划分成了子问题
 *
 * Author: Qi
 * Date: 09-14-2021
 */
public class No64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int[][] ans = new int[grid.length][grid[0].length];
        ans[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            ans[i][0] = ans[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            ans[0][i] = ans[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                ans[i][j] = grid[i][j] + Math.min(ans[i-1][j], ans[i][j-1]);
            }
        }
        return ans[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        No64 no64 = new No64();
        int i = no64.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
        System.out.println(i);
    }
}
