package com.qi.algorithm.stringPro;

/**
 * Description: Perfect Number 完美数
 * Author: Qi
 * Date: 12-31-2021
 */
public class No507 {

    public boolean checkPerfectNumber(int num) {
        int ans = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0){
                ans += i;
            }
        }
        return ans == num;
    }

    public static void main(String[] args) {
        No507 no507 = new No507();
        System.out.println(no507.checkPerfectNumber(28));
    }
}
