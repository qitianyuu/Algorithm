package com.qi.algorithm.stringPro;

/**
 * Description: Consecutive Characters 连续字符
 *
 * 思路：一次遍历，找出最长相同字串
 *
 * Author: Qi
 * Date: 12-01-2021
 */
public class No1446 {

    public int maxPower(String s) {
        if (s.length() < 2) return s.length();
        int ans = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                cur++;
            }else {
                ans = Math.max(ans, cur);
                cur = 1;
            }
        }
        ans = Math.max(ans, cur);
        return ans;
    }

    public static void main(String[] args) {
        No1446 no1446 = new No1446();
        System.out.println(no1446.maxPower("cc"));
    }
}
