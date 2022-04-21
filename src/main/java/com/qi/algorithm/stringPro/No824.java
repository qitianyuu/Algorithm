package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Goat Latin 山羊拉丁文
 * Author: Qi
 * Date: 2022/4/21
 */
public class No824 {

    public String toGoatLatin(String sentence) {
        String[] sentences = sentence.split(" ");
        StringBuffer ans = new StringBuffer();
        Character []yuan = new Character[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 1; i <= sentences.length; i++) {
            String tmp = sentences[i - 1];
            if (Arrays.asList(yuan).contains(Character.toLowerCase(tmp.charAt(0)))){
                ans.append(tmp).append("ma");
            }else {
                ans.append(tmp.substring(1)).append(tmp.charAt(0)).append("ma");
            }
            for (int j = 0; j < i; j++) {
                ans.append("a");
            }
            ans.append(" ");
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        No824 no824 = new No824();
        System.out.println(no824.toGoatLatin("I speak Goat Latin"));
    }
}
