package com.qi.algorithm.stringPro;

/**
 * Description: Add Strings 字符串相加
 * Author: Qi
 * Date: 08-26-2021
 */
public class No415 {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
            return "" ;
        }

        StringBuffer sb = new StringBuffer();
        int lena = num1.length() - 1, lenb = num2.length() - 1, add = 0;
        while (lena >= 0 || lenb >= 0 || add > 0){
            int c1 = lena >= 0 ? num1.charAt(lena) - '0' : 0;
            int c2 = lenb >= 0 ? num2.charAt(lenb) - '0' : 0;
            sb.append((char)((c1 + c2 + add) % 10 +'0'));
            add = (c1 + c2 + add) / 10;
            lena--;
            lenb--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No415 no415 = new No415();
        String str = no415.addStrings("9", "99");
        System.out.println(str);
    }
}
