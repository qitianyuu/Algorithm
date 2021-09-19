package com.qi.algorithm.stringPro;

/**
 * Description: Total Hamming Distance 汉明距离总和
 *
 * 思路：关键在于两点
 *      1、如何计算两个数的二进制第 i 位: 先右移 i 位，然后再和 1 做 & 运算(位运算)。
 *      2、如何统计每两个之间的距离: 假设 n 个数，tmp 个 1，n-tmp 个0，则 tmp * (n - tmp) 就是距离和。
 *
 * Author: Qi
 * Date: 09-18-2021
 */
public class No477 {

    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int tmp = 0;
            for (int num : nums) {
                tmp += (num >> i) & 1;
            }
            ans += tmp * (n - tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        No477 no477 = new No477();
        int i = no477.totalHammingDistance(new int[]{4, 14, 2});
        System.out.println(i);
    }
}
