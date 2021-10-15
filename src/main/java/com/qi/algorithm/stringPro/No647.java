package com.qi.algorithm.stringPro;

/**
 * Description: Palindromic Substrings 回文子串
 *
 * 思路：回文串，就是遍历每一个，然后中心扩散，注意单数和双数，所以循环次数为 2n - 1 次。
 *
 * Author: Qi
 * Date: 10-15-2021
 */
public class No647 {

    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >=0 && right <n && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No647 no647 = new No647();
        System.out.println(no647.countSubstrings("aaa"));
    }
}
