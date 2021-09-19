package com.qi.algorithm.stringPro;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Simplify Path 简化路径
 *
 * 思路：利用栈的思想，遇到路径入栈，遇到 .. 出栈，使用双端队列实现。
 *
 * Author: Qi
 * Date: 09-15-2021
 */
public class No71 {

    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<>();
        String[] tmp = path.split("/");
        for (int i = 0; i < tmp.length; i++) {
            String s = tmp[i];
            if (s.equals("") || s.equals(".")) continue;
            else if (s.equals("..")){
                if (!queue.isEmpty()) queue.removeLast();
            }
            else queue.addLast(s);
        }
        StringBuffer ans = new StringBuffer();
        while (!queue.isEmpty()){
            ans.append("/").append(queue.removeFirst());
        }
        return ans.toString().length() == 0 ? "/" : ans.toString();
    }

    public static void main(String[] args) {
        No71 no71 = new No71();
        String s = no71.simplifyPath("/a//b////c/d//././/..");
        System.out.println(s);
    }
}
