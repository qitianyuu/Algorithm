package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description:  Valid Anagram 有效的字母异位词
 *
 * 思路：对两个字符串转成char数组，然后用arrays.sort进行排序，输出arrays.equals，即可。
 *
 * 维护一个26元素的hash表，通过遍历第一个string得到元素及个数，遍历第二个减去对应个数，若小于零则false
 *
 * Author: Qi
 * Date: 08-26-2021
 */
public class No242 {

    //字符串排序
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a,b);
    }

    //哈希表
    public boolean isAnagram1(String s, String t){
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
         No242 no242 = new No242();
         boolean b = no242.isAnagram1("anagram", "nagaram");
        System.out.println(b);
    }
}
