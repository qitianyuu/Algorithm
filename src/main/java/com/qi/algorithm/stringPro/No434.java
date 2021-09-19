package com.qi.algorithm.stringPro;

/**
 * Description: Number of Segments in a String 字符串中的单词数
 *
 * 重点：//s+ 代替空格进行划分
 *
 * Author: Qi
 * Date: 08-26-2021
 */
public class No434 {

    public int countSegments(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String tmp = s.trim();
        if (tmp.equals("")){
            return 0;
        }
        String[] s1 = tmp.split("\\s+");
        return s1.length;
    }

    public static void main(String[] args) {
        No434 no434 = new No434();
        int ans = no434.countSegments(", , , ,        a, eaefa");
        System.out.println(ans);
    }
}
