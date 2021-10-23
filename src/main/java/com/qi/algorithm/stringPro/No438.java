package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Find All Anagrams in a String 找到字符串中所有字母异位词
 *
 * 思路：哈希表 + 滑动窗口，哈希表就是 26 个字母的出现次数
 *      窗口大小为字符串 p 的长度，然后右移，移一次判断一次哈希表是否相等。
 *
 * Author: Qi
 * Date: 10-23-2021
 */
public class No438 {

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> ans = new ArrayList<>();
        if (n < m) return ans;
        int[] sChar = new int[26];
        int[] pChar = new int[26];
        for (int i = 0; i < m; i++) {
            sChar[s.charAt(i)-'a'] += 1;
            pChar[p.charAt(i)-'a'] += 1;
        }
        if (Arrays.equals(sChar, pChar))ans.add(0);
        for (int i = m; i < n; i++) {
            sChar[s.charAt(i)-'a'] += 1;
            sChar[s.charAt(i-m)-'a'] -= 1;
            if (Arrays.equals(sChar, pChar))ans.add(i - m + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        No438 no438 = new No438();
        System.out.println(no438.findAnagrams("cbaebabacd", "abc"));
    }
}
