package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: 宝石补给
 * Author: Qi
 * Date: 2022/4/22
 */
public class LCP50 {

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int x = operation[0];
            int y = operation[1];
            int tmp = gem[x] / 2;
            gem[x] -= tmp;
            gem[y] += tmp;
        }

        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }

    public static void main(String[] args) {
        LCP50 lcp50 = new LCP50();
        System.out.println(lcp50.giveGem(new int[]{3, 1, 2}, new int[][]{{0, 2}, {2, 1}, {2, 0}}));
    }
}
