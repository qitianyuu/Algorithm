package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Hand of Straights 一手顺子
 *
 * 思路：构建 visited 数组，不断循环并每次选择符合的牌，直至结束
 *
 * Author: Qi
 * Date: 12-30-2021
 */
public class No846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        int[] visited = new int[n];
        int m = n / groupSize;
        for (int i = 0; i < m; i++) {
            int tmp = 0, num = 0, p = -1;
            while (num < groupSize){
                if (tmp >= n)return false;
                if (visited[tmp] != 0 || (num != 0 && p + 1 != hand[tmp])){
                    tmp++;
                    if (tmp >= n)return false;
                }else {
                    p = hand[tmp];
                    visited[tmp] = 1;
                    num++;
                    tmp++;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No846 no846 = new No846();
        System.out.println(no846.isNStraightHand(new int[]{1, 1, 2, 2, 3, 4}, 3));
    }
}
