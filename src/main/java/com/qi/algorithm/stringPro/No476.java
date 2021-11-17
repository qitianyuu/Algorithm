package com.qi.algorithm.stringPro;

/**
 * Description: Number Complement 数字的补数
 *
 * 思路：循环不断取出最后一位，取反并加到 ans 中。
 *
 * Author: Qi
 * Date: 11-17-2021
 */
public class No476 {

    public int findComplement(int num) {
        if (num == 0)return 1;
        int ans = 0;
        for (int i = 0; num != 0; i++) {
            int tmp = (num % 2);
            ans += tmp == 1 ? 0 : Math.pow(2, i);
            num = num >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        No476 no476 = new No476();
        System.out.println(no476.findComplement(1));
    }
}
