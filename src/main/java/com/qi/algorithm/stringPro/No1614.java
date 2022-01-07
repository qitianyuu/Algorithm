package com.qi.algorithm.stringPro;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Maximum Nesting Depth of the Parentheses 括号的最大嵌套深度
 *
 * 思路：用队列，记录最大的 size 即可。
 *
 * Author: Qi
 * Date: 01-07-2022
 */
public class No1614 {

    public int maxDepth(String s) {
        Deque<Character> q = new LinkedList<>();
        int n = s.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '('){
                q.offer(c);
                max = Math.max(max, q.size());
            }
            if (c == ')' && !q.isEmpty()){
                q.removeLast();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No1614 no1614 = new No1614();
        System.out.println(no1614.maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
