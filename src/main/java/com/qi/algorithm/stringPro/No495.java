package com.qi.algorithm.stringPro;

/**
 * Description: Teemo Attacking 提莫攻击
 *
 * 思路：记录上一个攻击的时间，判断是否在冷却时间内。
 *
 * Author: Qi
 * Date: 11-10-2021
 */
public class No495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        int p = -duration;
        for (int time : timeSeries) {
            if (time < p + duration){
                ans += duration - (p + duration - time);
            }else {
                ans += duration;
            }
            p = time;
        }
        return ans;
    }

    public static void main(String[] args) {
        No495 no495 = new No495();
        System.out.println(no495.findPoisonedDuration(new int[]{1, 2}, 2));
    }
}
