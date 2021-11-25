package com.qi.algorithm.stringPro;

/**
 * Description: Poor Pigs 可怜的小猪
 *
 * 思路：轮数加一为底，求的log(buckets) 天花板即为答案
 *
 * Author: Qi
 * Date: 11-25-2021
 */
public class No485 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int ro = minutesToTest / minutesToDie + 1;
        int ans = (int) Math.ceil(Math.log(buckets) / Math.log(ro));
        return ans;
    }

    public static void main(String[] args) {
        No485 no485= new No485();
        System.out.println(no485.poorPigs(1000, 15, 60));
    }
}
