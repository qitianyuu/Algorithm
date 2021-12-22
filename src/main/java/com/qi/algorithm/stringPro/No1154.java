package com.qi.algorithm.stringPro;

/**
 * Description: Day of the Year 一年中的第几天
 *
 * 思路：主要是如何判断是否是闰年
 *
 * Author: Qi
 * Date: 12-22-2021
 */
public class No1154 {

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            months[1]++;
        }
        int ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += months[i];
        }
        return ans + day;
    }

    public static void main(String[] args) {
        No1154 no1154 = new No1154();
        System.out.println(no1154.dayOfYear("2019-01-09"));
    }
}
