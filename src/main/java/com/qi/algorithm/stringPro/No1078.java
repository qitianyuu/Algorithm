package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Occurrences After Bigram Bigram 分词
 *
 * 思路：一次遍历找到匹配的答案。
 *
 * Author: Qi
 * Date: 12-26-2021
 */
public class No1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        if (words.length < 2)return new String[]{};
        for (int i = 2; i < words.length; i++) {
            if (words[i-1].equals(second) && words[i-2].equals(first)){
                ans.add(words[i]);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        No1078 no1078 = new No1078();
        System.out.println(Arrays.toString(no1078.findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }
}
