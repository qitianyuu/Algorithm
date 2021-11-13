package com.qi.algorithm.stringPro;

/**
 * Description: Detect Capital 检测大写字母
 * Author: Qi
 * Date: 11-13-2021
 */
public class No520 {

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)return true;
        int flag1 = 0, flag2 = 0, flag3 = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0 && word.charAt(i) <= 'Z' && word.charAt(i) >= 'A'){
                flag1 = 1;
            }
            if (i != 0 && word.charAt(i) <= 'Z' && word.charAt(i) >= 'A'){
                flag2 = 1;
            }
            if (i != 0 && word.charAt(i) <= 'z' && word.charAt(i) >= 'a'){
               flag3 = 1;
            }
            if (flag2 == 1 && flag3 == 1)return false;
        }
        if (flag1 == 0 && flag2 == 0 && flag3 == 1)return true;
        if (flag1 == 1 && flag2 == 0 && flag3 == 1)return true;
        if (flag1 == 1 && flag2 == 1 && flag3 == 0)return true;
        return false;
    }

    public static void main(String[] args) {
        No520 no520 = new No520();
        System.out.println(no520.detectCapitalUse("Leetcode"));
    }
}
