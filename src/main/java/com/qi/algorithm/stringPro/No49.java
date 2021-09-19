package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Group Anagrams 字母异位词分组
 *
 * 思路：任务是将字母异位词合并到一起，通过将所有字幕排序，异位词应该得到相同的序列
 *      然后再将其以 k-v 的形式放入 map 中，返回 map.values
 *
 * Author: Qi
 * Date: 09-13-2021
 */
public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char [] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String k = new String(tmp);
            List<String> list = map.getOrDefault(k, new ArrayList<>());
            list.add(str);
            map.put(k,list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        No49 no49 = new No49();
        String [] s = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = no49.groupAnagrams(s);
        System.out.println(lists.toString());
    }
}
