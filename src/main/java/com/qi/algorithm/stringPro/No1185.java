package com.qi.algorithm.stringPro;

/**
 * Description: Day of the Week 一周中的第几天
 *
 * 思路：1970 年的第一天是周四，然后计算天数和，最后加三并取余。
 *
 * Author: Qi
 * Date: 01-03-2022
 */
public class No1185 {

    public String dayOfTheWeek(int day, int month, int year) {
        String[]  mouthsString = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            months[1]++;
        }
        int ans = 365 * (year - 1971) + (year - 1969) / 4;
        for (int i = 0; i < month - 1; i++) {
            ans += months[i];
        }
        ans += day;
        return mouthsString[(ans + 3) % 7];
    }

    public static void main(String[] args) {
        No1185 no1185 = new No1185();
        System.out.println(no1185.dayOfTheWeek(31, 8, 2019));
    }
}
