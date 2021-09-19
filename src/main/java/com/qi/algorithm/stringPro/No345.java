package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Reverse Vowels of a String 反转字符串中的元音字母
 * Author: Qi
 * Date: 08-26-2021
 */
public class No345 {

    public String reverseVowels(String s) {
        if (s.length() == 0){
            return s;
        }
        Set<Character> c = new HashSet<>();
        c.add('A');
        c.add('E');
        c.add('I');
        c.add('O');
        c.add('U');
        c.add('a');
        c.add('e');
        c.add('i');
        c.add('o');
        c.add('u');

        char[] s1 = s.toCharArray();
        int h = 0, t = s.length() - 1;
        while (h < t){
            if (!c.contains(s1[h])){
                h++;
                continue;
            }
            if (!c.contains(s1[t])){
                t--;
                continue;
            }

            char tmp = s1[h];
            s1[h] = s1[t];
            s1[t] = tmp;
            h++;t--;
        }
        return String.valueOf(s1);
    }

    public static void main(String[] args) {
        No345 no345 = new No345();
        String ans = no345.reverseVowels("leetcode");
        System.out.println(ans);
    }
}
