package com.qi.algorithm.tree;

/**
 * Description: Word Search 单词搜索
 *
 * 思路：递归求解
 *
 * Author: Qi
 * Date: 09-08-2021
 */
public class No79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean b = check(board, visited, word, i, j, 0);
                if (b) return true;
            }
        }
        return false;

    }

    private boolean check(char[][] board, boolean[][] visited, String word, int i, int j, int total) {
        if (board[i][j] != word.charAt(total)){
            return false;
        }else if (total == word.length() -1){
            return true;
        }
        boolean result = false;
        visited[i][j] = true;
        int[][] dire = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        for (int k = 0; k < dire.length; k++) {
            int newi = i + dire[k][0];
            int newj = j + dire[k][1];
            if (newi >=0 && newi < board.length && newj >= 0 && newj <board[0].length){
                if (!visited[newi][newj]){
                    boolean flag = check(board, visited, word, newi, newj, total+1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }

    public static void main(String[] args) {
        No79 no79 = new No79();
        boolean abccee = no79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCEE");
        System.out.println(abccee);
    }
}
