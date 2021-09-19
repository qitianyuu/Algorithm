package com.qi.algorithm.stringPro;

import java.util.HashMap;

/**
 * Description: Valid Sudoku 有效的数独
 *
 * 思路：一次遍历，做三个 map 进行 value -> num 的映射，然后判断是否重复。
 *      map.getOrDefault() 方法！
 *
 * Author: Qi
 * Date: 09-10-2021
 */
public class No36 {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer> [] row = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];

        //初始化
        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char tmp = board[i][j];
                if (tmp != '.'){
                    int boxNum = (i / 3) * 3 + j / 3;
                    int tmpNum = Integer.valueOf(tmp);
                    row[i].put(tmpNum, row[i].getOrDefault(tmpNum, 0) + 1);
                    columns[j].put(tmpNum, columns[j].getOrDefault(tmpNum, 0) + 1);
                    boxes[boxNum].put(tmpNum, boxes[boxNum].getOrDefault(tmpNum, 0) + 1);
                    if (row[i].get(tmpNum) > 1 || columns[j].get(tmpNum) > 1 || boxes[boxNum].get(tmpNum) > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }
}
