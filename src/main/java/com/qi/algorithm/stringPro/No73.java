package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Set Matrix Zeroes 矩阵置零
 *
 * 思路：两次遍历，一次找出 0， 一次更新矩阵
 *
 * Author: Qi
 * Date: 09-15-2021
 */
public class No73 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0){
                        if (!x.contains(i))x.add(i);
                        if (!y.contains(j))y.add(j);
                    }
                }
        }
        x.forEach(item -> {
            for (int i = 0; i < n; i++) {
                matrix[item][i] = 0;
            }
        });
        y.forEach(item -> {
            for (int i = 0; i < m; i++) {
                matrix[i][item] = 0;
            }
        });
    }

    public static void main(String[] args) {
        No73 no73 = new No73();
        no73.setZeroes(new int[][]{{0,0,0,5},
                                   {4,3,1,4},
                                   {0,1,1,4},
                                   {1,2,1,3},
                                   {0,0,1,1}});
    }
}
