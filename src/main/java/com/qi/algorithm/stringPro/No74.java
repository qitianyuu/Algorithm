package com.qi.algorithm.stringPro;

/**
 * Description: Search a 2D Matrix 搜索二维矩阵
 *
 * 思路：先确定行索引，再从行中遍历
 *      后面可以考虑二分查找等。
 *
 * Author: Qi
 * Date: 09-15-2021
 */
public class No74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[0][0] > target)return false;
        int m = matrix.length, n = matrix[0].length;
        if (m == 1 && n == 1)return matrix[0][0] == target;
        int x = m-1;
        for (int i = 0; i < m-1; i++) {
            if (matrix[i][0] <= target && matrix[i+1][0] >target){
                x = i;
                break;
            }
        }
        if (m == 1){
            for (int i = 0; i < n; i++) {
                if (matrix[0][i] == target)return true;
                if (matrix[0][i] > target)return false;
            }
        }else {
            for (int i = 0; i < n; i++) {
                if (matrix[x][i] == target)return true;
                if (matrix[x][i] > target)return false;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        No74 no74 = new No74();
        boolean b = no74.searchMatrix(new int[][]{{1},{3}}, 3);
        System.out.println(b);
    }
}
