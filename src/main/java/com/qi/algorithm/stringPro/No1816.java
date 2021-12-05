package com.qi.algorithm.stringPro;

/**
 * Description: Truncate Sentence 截断句子
 *
 * 思路：从前往后找第 k 个空格，返回前面的字串即可
 *
 * Author: Qi
 * Date: 12-06-2021
 */
public class No1816 {

    public String truncateSentence(String s, int k) {
        int i = 0, idx = 0;
        s = s.trim();
        for (idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == ' '){
                i++;
                if (i == k){
                    break;
                }
            }
        }
        return s.substring(0, idx);
    }

    public static void main(String[] args) {
        No1816 no1816 = new No1816();
        System.out.println(no1816.truncateSentence("Hello how are you Contestant", 5));
    }
}
