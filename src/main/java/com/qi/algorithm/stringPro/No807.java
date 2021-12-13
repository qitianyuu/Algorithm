package com.qi.algorithm.stringPro;

/**
 * Description: Max Increase to Keep City Skyline 保持城市天际线
 *
 * 思路：每个位置能增加的高度就是行和列最高的两个值中的最小值
 *
 * Author: Qi
 * Date: 12-13-2021
 */
public class No807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = grid[i][j];
                int maxrow = Integer.MIN_VALUE;
                int maxcol = Integer.MIN_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != i){
                        maxcol = Math.max(maxcol, grid[k][j]);
                    }
                    if (k != j){
                        maxrow = Math.max(maxrow, grid[i][k]);
                    }
                }
                if (tmp < Math.min(maxcol, maxrow)){
                    ans += Math.min(maxcol, maxrow) - tmp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No807 no807 = new No807();
        System.out.println(no807.maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }
}
