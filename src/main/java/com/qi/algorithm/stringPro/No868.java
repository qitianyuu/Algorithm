package com.qi.algorithm.stringPro;

/**
 * Description: Binary Gap 二进制间距
 * Author: Qi
 * Date: 2022/4/24
 */
public class No868 {

    public int binaryGap(int n) {
        int max = Integer.MIN_VALUE;
        int flag = 0;
        int p = 0;
        while (n != 0){
            int tmp = n % 2;
            if (tmp == 1){
                max = Math.max(max, p);
                p = 0;
                flag = 1;
            }
            if (flag != 0){
                p++;
            }
            n >>= 1;
        }
        return max;
    }

    public static void main(String[] args) {
        No868 no868 = new No868();
        System.out.println(no868.binaryGap(8));
    }
}
