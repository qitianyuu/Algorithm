package com.qi.algorithm.stringPro;

/**
 * Description: Number of Islands 岛屿数量
 *
 * 思路：dfs的思路，先找到一个陆地，然后遍历将与这块陆地相连的所有陆地都标志成访问过的，然后一次循环每个点，最后得出陆地总数。
 *
 * Author: Qi
 * Date: 09-29-2021
 */
public class No200 {

    int total = 0;
    public int numIslands(char[][] grid) {
        if (grid.length == 0)return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1'){
                    total++;
                    dfs(grid, i, j);
                }
            }
        }
        return total;
    }

    private void dfs(char[][] grid, int m, int n) {
        if (m >= grid.length || n >= grid[0].length || m<0 || n < 0 || grid[m][n] == '0') {
            return;
        }
        grid[m][n] = '0';
        dfs(grid, m+1, n);
        dfs(grid, m, n+1);
        //dfs(grid, m-1, n);
        //dfs(grid, m, n-1);
    }

    public static void main(String[] args) {
        No200 no200 = new No200();
        int i = no200.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
        System.out.println(i);
    }
}
