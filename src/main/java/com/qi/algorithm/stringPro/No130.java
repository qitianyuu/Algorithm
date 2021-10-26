package com.qi.algorithm.stringPro;

/**
 * Description: Surrounded Regions 被围绕的区域
 *
 * 思路：难点在于怎么去判断是否被围了起来，因为边界可以延伸到内部
 *      所以从边界入手，遍历边界上的每个点，可达的所有 O 都标记一下
 *      然后完成 dfs 之后得到的矩阵中仍然没有被标记的就是边界不可达的，即被围绕的
 *      所以此题从边界入手 dfs 遍历所有，最后按照是否标记进行覆盖
 *
 * Author: Qi
 * Date: 10-26-2021
 */
public class No130 {

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        if (m * n == 0 || m <3 || n < 3)return;
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        for (int i = 1; i < m-1; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'Q'){
                    board[i][j] = 'O';
                }else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y <0 || y >= board[0].length || board[x][y] != 'O')return;
        board[x][y] = 'Q';
        dfs(board, x-1, y);
        dfs(board, x, y-1);
        dfs(board, x+1, y);
        dfs(board, x, y+1);
    }

    public static void main(String[] args) {
        No130 no130 = new No130();
        no130.solve(new char[][]{{'X'}});
    }
}
