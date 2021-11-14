package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Map Sum Pairs 键值映射
 *
 * 思路：暴力解法，遍历 Map 筛选出前缀相同的进行加和。
 *
 * Author: Qi
 * Date: 11-14-2021
 */
public class No677 {

    Map<String, Integer> map;
    public No677() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            if (en.getKey().startsWith(prefix)){
                ans += en.getValue();
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
