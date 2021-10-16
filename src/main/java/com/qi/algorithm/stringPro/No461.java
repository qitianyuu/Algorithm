package com.qi.algorithm.stringPro;

/**
 * Description: Hamming Distance 汉明距离
 *
 * 思路：先对两个数取异或操作，然后统计 1 的个数。
 *      可以用内置函数 Integer.bitCount(n);
 *
 * Author: Qi
 * Date: 10-16-2021
 */
public class No461 {

    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int ans = 0;
        while (n > 0){
            ans += n % 2;
            n = n >> 1;
        }
        return ans;
        //return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        No461 no461 = new No461();
        System.out.println(no461.hammingDistance(1, 4));
    }
}
