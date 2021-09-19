package com.qi.algorithm.stringPro;

/**
 * Description: 168.  Excel Sheet Column Title Excel 表列名称
 *
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 *
 * 本质上是进制转换问题，从十进制转换到二十六进制，分别由二十六个字母代表1-26
 * Author: Qi
 * Date: 08-25-2021
 */
public class No168 {

    public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0){
            int tmp = (columnNumber - 1) % 26 + 1;
            sb.append((char)(tmp - 1 + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        No168 no168 = new No168();
        String s =  no168.convertToTitle(2147483647);
        System.out.println(s);
    }
}
