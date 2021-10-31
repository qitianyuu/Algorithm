package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: Keyboard Row 键盘行
 *
 * 思路：遍历每个单词，查看是否处于同一个行内
 *
 * Author: Qi
 * Date: 10-31-2021
 */
public class No500 {

    public String[] findWords(String[] words) {
        String line1 = "qwertyuiop";
        String line2 = "asdfghjkl";
        String line3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for (String word : words) {
            int flag1, flag2, flag3;
            flag1 = flag2 = flag3 = 1;
            for (int i = 0; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (!line1.contains(String.valueOf(c))){
                    flag1 = 0;
                }
                if (!line2.contains(String.valueOf(c))){
                    flag2 = 0;
                }
                if (!line3.contains(String.valueOf(c))){
                    flag3 = 0;
                }
            }
            if (flag1 + flag2 + flag3 >= 1){
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        No500 no500 = new No500();
        System.out.println(Arrays.toString(no500.findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
    }
}
