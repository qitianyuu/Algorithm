package com.qi.algorithm.stringPro;

/**
 * Description: To Lower Case 转换成小写字母
 *
 * 思路：大写变小写、小写变大写 : 字符 ^= 32;
 *      大写变小写、小写变小写 : 字符 |= 32;
 *      小写变大写、大写变大写 : 字符 &= -33;
 *
 * Author: Qi
 * Date: 12-12-2021
 */
public class No709 {

    public String toLowerCase(String s) {
        //return s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }

    public String toLowerCase1(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append((char)(s.charAt(i) | 32));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No709 no709 = new No709();
        System.out.println(no709.toLowerCase1("Hello"));
    }
}
