package com.qi.algorithm.stringPro;

/**
 * Description: Best Time to Buy and Sell Stock 买卖股票的最佳时机
 *
 * 思路：也算是动态规划，维护两个数组，一个放第 i 天为止，买入的最低价，另一个放以买入最低价买入，与当前天的差值
 *      这样就可以不断更新最大值。
 *
 * Author: Qi
 * Date: 10-10-2021
 */
public class No121 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int cMin = Integer.MAX_VALUE;
        int eMax = Integer.MIN_VALUE;
        int[] in = new int[n];
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            if (prices[i] < cMin){
                cMin = prices[i];
            }
            in[i] = cMin;
            money[i] = prices[i] - in[i];
            if (money[i] > eMax)eMax = money[i];
        }
        return eMax;
    }

    public static void main(String[] args) {
        No121 no121 = new No121();
        int i = no121.maxProfit(new int[]{7,6,4,3,1});
        System.out.println(i);
    }

}
