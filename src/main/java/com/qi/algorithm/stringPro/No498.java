package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Diagonal Traverse 对角线遍历
 *
 * 思路：模拟法，先从 (0, 0) 开始，然后有六种情况
 *      分别是右上->方向碰到顶向右一位、碰到右边界向下一位、碰到右上角向下一位，以及左下的三种情况。
 *      分别判断即可，同时设置变量保存方向信息。
 *
 * Author: Qi
 * Date: 02-06-2022
 */
public class No498 {

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int direct = 1; // 右上 -1左下
        int curX = 0, curY = 0;
        for (int i = 0; i < m * n; i++) {
            ans[i] = mat[curX][curY];
            if (direct == 1){
                if (!(curX - 1 < 0 || curY + 1 >= n)){
                    curX = curX - 1;
                    curY = curY + 1;
                }else if (curX - 1 < 0 && curY + 1 >= n){
                    curX = curX + 1;
                    direct = direct * -1;
                }else {
                    if (curY + 1 >= n){
                        curX = curX + 1;
                    }else {
                        curY = curY + 1;
                    }
                    direct = direct * -1;
                }
            }else {
                if (!(curX + 1 >= m || curY - 1 < 0)){
                    curX = curX + 1;
                    curY = curY - 1;
                }else if (curX + 1 >= m && curY - 1 < 0){
                    curY = curY + 1;
                    direct = direct * -1;
                } else {
                    if (curX + 1 >= m){
                        curY = curY + 1;
                    }else {
                        curX = curX + 1;
                    }
                    direct = direct * -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No498 no498 = new No498();
        System.out.println(Arrays.toString(no498.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }
}
