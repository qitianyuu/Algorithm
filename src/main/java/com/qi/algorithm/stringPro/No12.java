package com.qi.algorithm.stringPro;

/**
 * Description: Integer to Roman 整数转罗马数字
 *
 * 思路：典型题，循环找最小的数，用字典存储。stringbuffer 放答案。
 *
 * Author: Qi
 * Date: 09-17-2021
 */
public class No12 {

    public String intToRoman(int num) {
        //I             1
        //V             5
        //X             10
        //L             50
        //C             100
        //D             500
        //M             1000

        int[] x = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] y = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuffer sb = new StringBuffer();
        while (num > 0){
            for (int i = 12; i >= 0; i--) {
                if (num >= x[i]){
                    sb.append(y[i]);
                    num -= x[i];
                }
            }   
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No12 no12 = new No12();
        String s = no12.intToRoman(1994);
        System.out.println(s);
    }
}
