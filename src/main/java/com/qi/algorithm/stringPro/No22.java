package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Generate Parentheses 括号生成
 *
 * 思路：其实就是给定个数，然后左右括号匹配，类似笛卡尔积的形式，只不过是要去掉不符合规则的
 *      所以可以用树去实现，root 节点是左括号，两颗子树分别为左右括号，注意递归条件，可以用回溯算法
 *
 * Author: Qi
 * Date: 09-13-2021
 */
public class No22 {


    public List<String> generateParenthesis(int n) {
        List<String> s = new ArrayList<>();
        if (n == 1){
            s.add("()");
            return s;
        }
        trackback(s, n, n, "");
        return s;

    }

    private void trackback(List<String> s, int left, int right, String cur) {
        if (left == 0 && right == 0){
            s.add(cur);
            return;
        }
        if (left == right){
            trackback(s, left-1, right, cur+"(");
        }else if (left < right){
            if (left > 0){
                trackback(s, left-1, right, cur+"(");
            }
            trackback(s, left, right-1, cur+")");
        }
    }

    public static void main(String[] args) {
        No22 no22 = new No22();
        List<String> list = no22.generateParenthesis(5);
        System.out.println(list.toString());
    }
}
