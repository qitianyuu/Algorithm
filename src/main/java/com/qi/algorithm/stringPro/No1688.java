package com.qi.algorithm.stringPro;

/**
 * Description: Count of Matches in Tournament 比赛中的配对次数
 *
 * 思路：更简单暴力的方法，return n - 1;
 *
 * Author: Qi
 * Date: 01-25-2022
 */
public class No1688 {

    public int numberOfMatches(int n) {
        int ans = 0;
        while (n != 1){
            if (n % 2 == 0){
                ans += n / 2;
                n = n / 2;
            }else {
                ans += n / 2;
                n = n / 2 + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No1688 no1688 = new No1688();
        System.out.println(no1688.numberOfMatches(7));
    }
}
