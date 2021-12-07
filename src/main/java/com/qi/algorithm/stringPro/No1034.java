package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Coloring A Border 边界着色
 *
 * 思路：题目意思是找出和给定坐标颜色一致的区域的边界，并用给定的颜色替换。
 *      深度优先遍历，查到边框就加入 List，最后涂色。
 *
 * Author: Qi
 * Date: 12-07-2021
 */
public class No1034 {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        List<int[]> board = new ArrayList<>();
        int orgColor = grid[row][col];
        visited[row][col] = true;
        dfs(grid, row, col, visited, board, orgColor);
        for (int i = 0; i < board.size(); i++) {
            grid[board.get(i)[0]][board.get(i)[1]] = color;
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, List<int[]> board, int orgColor) {
        int m = grid.length, n = grid[0].length;
        boolean isBoard = false;
        int[][]dic = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int x = row + dic[i][0], y = col + dic[i][1];
            if (!(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == orgColor)){
                isBoard = true;
            }else if (!visited[x][y]){
                visited[x][y] = true;
                dfs(grid, x, y, visited, board, orgColor);
            }
        }
        if (isBoard){
            board.add(new int[]{row, col});
        }
    }

    public static void main(String[] args) {
        No1034 no1034 = new No1034();
        int[][] ints = no1034.colorBorder(new int[][]{{1, 1}, {1, 2}}, 0, 0, 3);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}
