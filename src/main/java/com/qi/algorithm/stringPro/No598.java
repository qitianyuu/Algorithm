package com.qi.algorithm.stringPro;

/**
 * Description: Range Addition II 范围求和 II
 * Author: Qi
 * Date: 11-07-2021
 */
public class No598 {

    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m*n;
        int min = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        for(int i = 0; i < ops.length; i++){
            min = Math.min(min, ops[i][0]);
            min1 = Math.min(min1, ops[i][1]);
        }
        return min * min1;
    }

    public static void main(String[] args) {
        No598 no598 = new No598();
        System.out.println(no598.maxCount(3, 3, new int[][]{{2,2},{3,3}}));
    }
}
