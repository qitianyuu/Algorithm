package com.qi.algorithm.stringPro;

/**
 * Description: Valid Tic-Tac-Toe State 有效的井字游戏
 *
 * 思路：1、X必须比O多1个或者相同，否则false
 *      2、X和O不能同时都是赢家，否则false
 *      3、X赢的时候必须比O多1个，否则false
 *      4、O赢得时候个数与X相同，否则false；
 *
 * Author: Qi
 * Date: 12-09-2021
 */
public class No794 {

    public boolean validTicTacToe(String[] board) {
        int xNum = 0, oNum = 0;
        int xWin = 0, oWin = 0;
        for (int i = 0; i < 3; i++) {
            String tmp = board[i];
            for (int j = 0; j < 3; j++) {
                if (tmp.charAt(j) == 'X') xNum++;
                if (tmp.charAt(j) == 'O') oNum++;
            }
        }
        xWin = isWin('X', board);
        oWin = isWin('O', board);

        if (!(xNum == oNum || xNum == oNum+1))return false;
        if (xWin == 1 && xNum != oNum + 1)return false;
        if (xWin + oWin == 2)return false;
        if (oWin == 1 && xNum != oNum)return false;
        return true;
    }

    private int isWin(char o, String[] board) {
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == o && board[1].charAt(i) == o && board[2].charAt(i) == o){
                return 1;
            }
            if (board[i].equals(String.valueOf(new char[]{o, o, o}))) return 1;
        }
        if (board[0].charAt(0) == o && board[2].charAt(2) == o && board[1].charAt(1) == o) return 1;
        if (board[0].charAt(2) == o && board[2].charAt(0) == o && board[1].charAt(1) == o) return 1;
        return 0;
    }

    public static void main(String[] args) {
        No794 no794 = new No794();
        System.out.println(no794.validTicTacToe(new String[]{"XOX","O O","XOX"}));
    }
}
