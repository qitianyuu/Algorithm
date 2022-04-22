package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: 守护太空城
 *
 * 思路：二进制保存时间信息，dfs遍历位置信息
 *
 * Author: Qi
 * Date: 2022/4/22
 */
public class LCP53 {

    int maxPosition = 0, maxTime = 1;

    public int defendSpaceCity(int[] time, int[] position) {
        this.maxTime = Arrays.stream(time).max().orElse(1);
        this.maxPosition = Arrays.stream(position).max().orElse(0);

        int[] attack = new int[maxPosition + 1];
        for (int i = 0; i < time.length; i++) {
            attack[position[i]] |= 1 << (time[i] - 1);
        }

        int[][] dp = new int[maxPosition + 1][1 << maxTime];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(attack, 0, 0, dp);
    }

    private int dfs(int[] attack, int pos, int p, int[][] dp) {

        if (pos > maxPosition) {
            return 0;
        }
        if (dp[pos][p] != -1) {
            return dp[pos][p];
        }

        int need = attack[pos] & (~p);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << maxTime); i++) {
            int single = need & (~i);
            int cost = dfs(attack, pos + 1, i, dp) + cost(single, 2) + cost(i, 3);
            min = Math.min(cost, min);
        }
        dp[pos][p] = min;
        return min;
    }


    public int cost(int attack, int cost){
        int total = 0;
        int p = 0;
        while (attack != 0){
            if (attack % 2 == 1){
                if (p == 0){
                    total += cost;
                }else {
                    total++;
                }
            }
            p = attack % 2;
            attack >>= 1;
        }
        return total;
    }


    public static void main(String[] args) {
        LCP53 lcp53 = new LCP53();
        System.out.println(lcp53.defendSpaceCity(new int[]{1, 1, 1, 2, 2, 3, 5}, new int[]{1, 2, 3, 1, 2, 1, 3}));
//        System.out.println(1 << 5);
    }
}
