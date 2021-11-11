package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Game of Life 生命游戏
 *
 * 思路：复制原数组，然后逐一判断是否符合条件。
 *
 * Author: Qi
 * Date: 11-11-2021
 */
public class No289 {

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][]ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = board[i][j];
                int tmp = cell(board, i, j);
                if ((board[i][j] == 1) && (tmp <2 || tmp > 3)){
                    ans[i][j] = 0;
                }else if ((board[i][j] == 0) && (tmp == 3)){
                    ans[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }

    private int cell(int[][] board, int i, int j) {
        int ans = 0;
        int[]dx = new int[]{-1,-1,-1,0,0,1,1,1};
        int[]dy = new int[]{-1,0,1,-1,1,-1,0,1};
        for (int k = 0; k < 8; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length){
                if (board[x][y] == 1) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No289 no289 = new No289();
        int[][] b = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        no289.gameOfLife(b);
        for (int[] ints : b) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
