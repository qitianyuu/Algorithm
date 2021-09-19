package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Sort Characters By Frequency 根据字符出现频率排序
 *
 * 思路：通过遍历一次得到每个字符的个数，用 map 存储
 *      然后排序，循环得到最后的答案
 *      这里又练习到了排序问题，map 的 value 的排序。
 *
 * Author: Qi
 * Date: 09-17-2021
 */
public class No451 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            int num = map.getOrDefault(tmp, 0);
            map.put(tmp, num + 1);
        }
        StringBuffer ans = new StringBuffer();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Character, Integer> mapping : list){
            for (int i = 0; i < mapping.getValue(); i++) {
                ans.append(mapping.getKey());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        No451 no451 = new No451();
        String ans = no451.frequencySort("abbbccdeeeee");
        System.out.println(ans);
    }
}
