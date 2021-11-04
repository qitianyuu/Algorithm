package com.qi.algorithm.stringPro;

/**
 * Description: Minimum Flips to Make a OR b Equal to c 或运算的最小翻转次数
 *
 * 思路：循环，如果 c 的某一位为 1，则 a 和 b 只要有一个为 1 就行 修改代价：1
 *      如果 c 的某一位为 0，则 a 和 b 都为 0 修改代价：2-a-b
 *
 * Author: Qi
 * Date: 11-04-2021
 */
public class No1318 {

    public int minFlips(int a, int b, int c) {
        int total = 0;
        while (a != 0 || b != 0 || c != 0){
            int a1, b1, c1;
            a1 = a == 0 ? 0:a%2;
            b1 = b == 0 ? 0:b%2;
            c1 = c == 0 ? 0:c%2;
            a = a>>1;
            b = b>>1;
            c = c>>1;
            if (c1 == 0){
                if (a+b != 0){
                    total += a1;
                    total += b1;
                }
            }else {
                if (a+b == 0){
                    total+=1;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        No1318 no1318 = new No1318();
        System.out.println(no1318.minFlips(2,6,5));
    }
}
