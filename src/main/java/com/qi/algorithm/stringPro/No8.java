package com.qi.algorithm.stringPro;

/**
 * Description: String to Integer (atoi) 字符串转换整数 (atoi)
 *
 * 思路：先去掉开头的空格，然后再判断有无标识位，最后迭代数字，并判断溢出，溢出是关键
 *
 * Author: Qi
 * Date: 09-08-2021
 */
public class No8 {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.equals(""))return 0;
        int f = 1;
        int ans = 0;
        if (s.charAt(0) == '-'){
            s = s.substring(1,s.length());
            f = -1;
        }else if (s.charAt(0) == '+'){
            s = s.substring(1,s.length());
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))){
                break;
            }
            int tmp = s.charAt(i) - '0';
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && tmp > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && tmp < Integer.MIN_VALUE % 10)){
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + f * tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        No8 no8 = new No8();
        int ans = no8.myAtoi("2147483648");
        System.out.println(ans);
    }
}
