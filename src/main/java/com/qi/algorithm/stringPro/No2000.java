package com.qi.algorithm.stringPro;

/**
 * Description: Reverse Prefix of Word 反转单词前缀
 * Author: Qi
 * Date: 02-02-2022
 */
public class No2000 {

    public String reversePrefix(String word, char ch) {
        int idx = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch){
                idx = i;
                break;
            }
        }
        if (idx == -1) return word;
        StringBuffer sb = new StringBuffer();
        for (int i = idx; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        for (int i = idx + 1; i < word.length(); i++) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No2000 no2000 = new No2000();
        System.out.println(no2000.reversePrefix("abcdefd", 'd'));
    }
}
