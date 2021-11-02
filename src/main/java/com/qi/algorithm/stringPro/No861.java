package com.qi.algorithm.stringPro;

/**
 * Description: Score After Flipping Matrix 翻转矩阵后的得分
 *
 * 思路：先把所有的第一列是零的全部转换成一，否则即使第一位是0，后面都是一也不如第一位是一大
 *      然后按列对比，如果某一列0多余1，则转换。
 *
 * Author: Qi
 * Date: 11-02-2021
 */
public class No861 {

    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0){
                reverseLine(grid, i);
            }
        }
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0)tmp++;
            }
            if (tmp > m / 2){
                reverseRow(grid, i);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp = tmp * 2 + grid[i][j];
            }
            ans += tmp;
        }
        return ans;
    }

    private void reverseRow(int[][] grid, int i) {
        for (int j = 0; j < grid.length; j++) {
            grid[j][i] = grid[j][i] == 0 ? 1 : 0;
        }
    }

    private void reverseLine(int[][] grid, int i) {
        for (int j = 0; j < grid[0].length; j++) {
            grid[i][j] = grid[i][j] == 0 ? 1 : 0;
        }
    }

    public static void main(String[] args) {
        No861 no861 = new No861();
        System.out.println(no861.matrixScore(new int[][]{{0,0,1,1}, {1,0,1,0}, {1,1,0,0}}));
    }
}
