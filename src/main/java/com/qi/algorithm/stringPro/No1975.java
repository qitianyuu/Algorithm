package com.qi.algorithm.stringPro;

/**
 * Description: Maximum Matrix Sum 最大方阵和
 *
 * 思路：这道题妙就妙在必须反转任意两个挨着的元素，而且，可以通过不断反转，让一个负号在矩阵中行走
 *      通过这一性质，可以得出，如果矩阵中有偶数个负数，则可以完全消掉，如果存在奇数个，则能消到最后剩一个
 *      因此，统计矩阵中负数的个数和绝对值加和即可。
 *
 * Author: Qi
 * Date: 11-01-2021
 */
public class No1975 {

    public long maxMatrixSum(int[][] matrix) {
        int minAbs = Integer.MAX_VALUE;
        int negaNum = 0;
        Long abs = 0l;
        for (int[] lines : matrix) {
            for (int item : lines) {
                if (item < 0){
                    negaNum ++;
                    item = -1 * item;
                }
                minAbs = Math.min(minAbs, item);
                abs += item;
            }
        }
        if (minAbs == 0) return abs;
        if (negaNum % 2 == 0) return abs;
        return abs - 2 * minAbs;
    }

    public static void main(String[] args) {
        No1975 no1975 = new No1975();
        System.out.println(no1975.maxMatrixSum(new int[][]{{1, -1}, {-1, 1}}));
    }
}
