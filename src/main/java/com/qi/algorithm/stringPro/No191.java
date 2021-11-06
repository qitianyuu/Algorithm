package com.qi.algorithm.stringPro;

/**
 * Description: Number of 1 Bits 位1的个数
 *
 * 思路：位运算，将末位一反转的操作技巧，
 *
 * Author: Qi
 * Date: 11-06-2021
 */
public class No191 {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0){
            n &= (n-1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        No191 no191 = new No191();
        System.out.println(no191.hammingWeight(00000000000000000000000000001011));
    }
}
