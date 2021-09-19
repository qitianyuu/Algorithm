package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Spiral Matrix 螺旋矩阵
 *
 * 思路：构造方向矩阵和方向标识位，这样就可以进行方向上的变化和 i, j 坐标的运算
 *      对总数进行迭代，判断何时该换方向，边界和已经访问过的。
 *
 * Author: Qi
 * Date: 09-13-2021
 */
public class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int []dx = {0, 1, 0, -1}; //横向
        int []dy = {1, 0, -1, 0}; //纵向
        int rows = matrix.length;
        int columns = matrix[0].length;
        int nexti, nextj;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0, j = 0, dire = 0, num = 0; num < rows*columns; num++) {
            ans.add(matrix[i][j]);
            matrix[i][j] = Integer.MIN_VALUE;
            nexti = i + dx[dire];
            nextj = j + dy[dire];
            if (nexti < 0 || nextj < 0 || nexti >= rows || nextj >= columns || matrix[nexti][nextj] == Integer.MIN_VALUE){
                dire = (dire + 1) % 4;
                nexti = i + dx[dire];
                nextj = j + dy[dire];
            }
            i = nexti;
            j = nextj;
        }
        return ans;
    }

    public static void main(String[] args) {
        No54 no54 = new No54();
        List<Integer> integers = no54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(integers.toString());

    }
}
