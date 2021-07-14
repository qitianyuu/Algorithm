package com.qi.algorithm.linkedList;

/**
 * Description: 给你一个字符串 s，找到 s 中最长的回文子串。
 * Author: Qi
 * Date: 07-13-2021
 */
public class No5 {

    public String longestPalindrome(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s,i,i);
            String s2 = palindrome(s,i,i+1);
            str = str.length() > s1.length() ? str : s1;
            str = str.length() > s2.length() ? str : s2;
        }
        return str;
    }

    public String palindrome(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        //substring 是前闭后开
        return s.substring(left + 1, right);
    }

    public static void main(String[] args) {
        String s = "acacac";
        No5 no5 = new No5();
        System.out.println(no5.longestPalindrome(s));
    }

}
