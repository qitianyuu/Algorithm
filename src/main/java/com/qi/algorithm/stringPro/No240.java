package com.qi.algorithm.stringPro;

/**
 * Description: Search a 2D Matrix II 搜索二维矩阵 II
 *
 * 思路：本题有一个性质，即从上到下，从左到右都是升序，所以选择左下角的点，
 *      往上就是减小，往右就是增加，因此只需要不断循环就可以找到。
 *
 * Author: Qi
 * Date: 10-18-2021
 */
public class No240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        if (m * n == 0)return false;
        int x = m - 1, y = 0;
        while (x >= 0 && y < n){
            if (matrix[x][y] == target)return true;
            if (matrix[x][y] > target) x--;
            else y++;
        }
        return false;
    }

    public static void main(String[] args) {
        No240 no240 = new No240();
        System.out.println(no240.searchMatrix(new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5));
    }
}
