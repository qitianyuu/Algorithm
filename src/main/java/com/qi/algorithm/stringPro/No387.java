package com.qi.algorithm.stringPro;

/**
 * Description: First Unique Character in a String 字符串中的第一个唯一字符
 * Author: Qi
 * Date: 08-26-2021
 */
public class No387 {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0){
            return -1;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (a[c - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No387 no387 = new No387();
        int ans = no387.firstUniqChar("aaaee");
        System.out.println(ans);
    }
}
