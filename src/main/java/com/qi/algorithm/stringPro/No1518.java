package com.qi.algorithm.stringPro;

/**
 * Description: Water Bottles 换酒问题
 *
 * 思路：别忘了更新变量时候存下副本，后面用的时候很可能就是更新后的值了
 *
 * Author: Qi
 * Date: 12-17-2021
 */
public class No1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int rest = 0, ans = numBottles;
        while ((numBottles + rest) >= numExchange){
            ans += (numBottles + rest) / numExchange;
            int numBottles_ = numBottles;
            numBottles = (numBottles + rest) / numExchange;
            rest = (numBottles_ + rest) % numExchange;

        }
        return ans;
    }

    public static void main(String[] args) {
        No1518 no1518 = new No1518();
        System.out.println(no1518.numWaterBottles(17, 3));
    }
}
