package com.qi.algorithm.stringPro;

/**
 * Description: Longest Common Prefix 最长公共前缀
 *
 * 思路：第一重循环为strs数组的第一个字符串元素的长度，第二重循环为strs的元素个数
 * 其中第二重循环注意不要越界
 *
 * Author: Qi
 * Date: 08-23-2021
 */
public class No14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            char tmp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != tmp){
                    return sb.toString();
                }
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No14 no14 = new No14();
        String [] s = {};
        String ans = no14.longestCommonPrefix(s);
        System.out.println(ans);
    }
}
