package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Word Pattern (单词规律)
 *
 * 思路：双相匹配，和No205类似，解法同205
 *
 * Author: Qi
 * Date: 08-26-2021
 */
public class No290 {

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.trim().split(" ");
        if (pattern.length() != split.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))){
                if (!map.get(pattern.charAt(i)).equals(split[i])){
                    return false;
                }
            }else {
                if (map.containsValue(split[i])){
                    return false;
                }
                map.put(pattern.charAt(i), split[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No290 no290 = new No290();
        boolean b = no290.wordPattern("abba", "dog e e dog");
        System.out.println(b);
    }
}
