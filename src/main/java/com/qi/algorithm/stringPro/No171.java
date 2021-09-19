package com.qi.algorithm.stringPro;

/**
 * Description: Excel Sheet Column Number Excel 表列序号
 *
 * 思路：将26进制转换成十进制
 *
 * Author: Qi
 * Date: 08-25-2021
 */
public class No171 {

    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0){
            return 0;
        }
        int len = columnTitle.length();
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            ans += (c - 'A' + 1) * Math.pow(26,len - i - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        No171 no171 = new No171();
        int ans = no171.titleToNumber("ZY");
        System.out.println(ans);
    }
}
