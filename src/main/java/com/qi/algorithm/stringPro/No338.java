package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Counting Bits 比特位计数
 *
 * 思路：笨办法，循环，位移，取余
 *      还可以用动态规划算法。
 *
 * Author: Qi
 * Date: 10-26-2021
 */
public class No338 {

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            int tmp = i;
            while (tmp > 0){
                ans[i] += tmp % 2;
                tmp = tmp>>1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No338 no338 = new No338();
        System.out.println(Arrays.toString(no338.countBits(5)));
    }
}
