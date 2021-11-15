package com.qi.algorithm.stringPro;

/**
 * Description: Bulb Switcher 灯泡开关
 *
 * 思路：第 k 个灯泡最后是否亮着取决于 0 到 n 有多少个约数，只要 k 不是完全平方数，则它就有偶数个约数
 *      如果他是完全平方数，则有奇数个约数，最后亮着。
 *      因此求根号n， 得到得数就是 0 到 n 之间的完全平方数个数，也就是亮着的个数。
 *
 * Author: Qi
 * Date: 11-15-2021
 */
public class No319 {

    //暴力解法，耗时
    public int bulbSwitch(int n) {
        if (n <= 1)return n;
        int[]ans = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            ans[i] = 1;
        }
        for (int step = 2; step <= n; step++) {
            for (int i = step; i <= n; i += step) {
                ans[i] = ans[i] == 1 ? 0 : 1;
            }
        }
        int ansNum = 0;
        for (int an : ans) {
            if (an == 1)ansNum++;
        }
        return ansNum;
    }

    public int bulbSwitch1(int n) {
        return (int) Math.sqrt(n+0.5);
    }


    public static void main(String[] args) {
        No319 no319 = new No319();
        System.out.println(no319.bulbSwitch(3));
    }
}
