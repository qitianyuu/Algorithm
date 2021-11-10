package com.qi.algorithm.stringPro;

/**
 * Description: Integer Break 整数拆分
 *
 * 思路：本题是固定结论，当拆成三时乘积最大。
 *      同 offer 14- I. 剪绳子
 *
 * Author: Qi
 * Date: 11-10-2021
 */
public class No343 {

    public int integerBreak(int n) {
        if (n <= 3) return n-1;
        int tmp1 = n / 3, tmp2 = n % 3;
        if (tmp2 == 1){
            return (int) (Math.pow(3,tmp1-1) * 4);
        }else if (tmp2 == 2){
            return (int) (Math.pow(3,tmp1) * 2);
        }
        else return (int) Math.pow(3,tmp1);
    }

    public static void main(String[] args) {
        No343 no343 = new No343();
        System.out.println(no343.integerBreak(10));
    }
}
