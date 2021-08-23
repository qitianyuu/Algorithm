package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Valid Parentheses 有效的括号
 *
 * 思路:通过map做索引，用栈来解决问题。
 *
 * Author: Qi
 * Date: 08-23-2021
 */
public class No20 {

    public boolean isValid(String s) {
        if (s == null){
            return false;
        }
        int len = s.length();
        if (len % 2 == 1){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char tmp = s.charAt(i);
            if (map.containsKey(tmp)){
                if (stack.isEmpty() || stack.peek() != map.get(tmp)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(tmp);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "";
        No20 no20 = new No20();
        boolean b = no20.isValid(str);
        System.out.println(b);
    }
}
