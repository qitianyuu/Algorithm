package com.qi.algorithm.stringPro;

/**
 * Description: 14- I. 剪绳子
 *
 * 思路：本题是数学证明题，当分为长度为 3 的绳子时有最大的乘积，因此对三取整，取余，计算乘积
 *
 * Author: Qi
 * Date: 11-04-2021
 */
public class Offer14_1 {

    public int cuttingRope(int n) {
        if (n <= 3)return n-1;
        int a = n / 3, b = n % 3;
        if (b == 0)return (int) Math.pow(3, a);
        if (b == 1)return (int) (Math.pow(3, a-1) * 4);
        return (int) (Math.pow(3, a) * 2);
    }

    public static void main(String[] args) {
        Offer14_1 offer14_1 = new Offer14_1();
        System.out.println(offer14_1.cuttingRope(10));
    }
}
