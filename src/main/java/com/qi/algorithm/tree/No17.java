package com.qi.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: Letter Combinations of a Phone Number 电话号码的字母组合
 *
 * 思路：经典回溯算法，先递归到底，其中每一步都做处理，然后回退，同时加入list
 *
 * Author: Qi
 * Date: 09-10-2021
 */
public class No17 {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0)return list;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        trackback(map, list, 0, digits, new StringBuffer());
        return list;


    }

    /**
     *
     * @param map 数字字幕对应关系
     * @param list 最终答案
     * @param index 当前层数
     * @param digits 输入数字序列
     * @param sb 当前的字符串
     */
    private void trackback(Map<Character, String> map, List<String> list, int index, String digits, StringBuffer sb) {
        if (index == digits.length()){
            list.add(sb.toString());
        }else {
            char c = digits.charAt(index);
            String str = map.get(c);
            for (int i = 0; i < str.length(); i++) {
                sb.append(str.charAt(i));
                trackback(map, list, index+1, digits, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        No17 no17 = new No17();
        List<String> list = no17.letterCombinations("234");
        list.forEach(item ->{
            System.out.println(item);
        });
    }
}
