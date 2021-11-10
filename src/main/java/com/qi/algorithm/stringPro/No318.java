package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Maximum Product of Word Lengths 最大单词长度乘积
 *
 * 思路：通过二重循环，两两比较，判断没有重复字母，更新最大值。
 *      其中，判断是否含有重复字母可以通过位运算进行，让26个字母，出现的为1，即可实现。
 *
 * Author: Qi
 * Date: 11-10-2021
 */
public class No318 {

    public int maxProduct(String[] words) {
        int max = Integer.MIN_VALUE;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (haveNoSame(words[i], words[j])){
                    max = Math.max(max, words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }

    private boolean haveNoSame(String word, String word1) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            set.add(word.charAt(i));
        }
        for (int i = 0; i < word1.length(); i++) {
            if (set.contains(word1.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No318 no318 = new No318();
        System.out.println(no318.maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
    }
}
