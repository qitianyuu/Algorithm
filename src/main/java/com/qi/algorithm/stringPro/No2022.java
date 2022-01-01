package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Convert 1D Array Into 2D Array 将一维数组转变成二维数组
 *
 * 思路：元旦快乐！
 *
 * Author: Qi
 * Date: 01-01-2022
 */
public class No2022 {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int c = original.length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < c; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        No2022 no2022 = new No2022();
        int[][] ints = no2022.construct2DArray(new int[]{1, 2, 3, 4}, 1, 4);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
