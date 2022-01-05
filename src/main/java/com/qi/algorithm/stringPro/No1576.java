package com.qi.algorithm.stringPro;

/**
 * Description: Replace All ?'s to Avoid Consecutive Repeating Characters 替换所有的问号
 * Author: Qi
 * Date: 01-05-2022
 */
public class No1576 {

    public String modifyString(String s) {
        if (!s.contains("?")) return s;
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '?'){
                if ((i == 0 ||(i != 0 && sb.charAt(i-1) != 'a')) && (i == n-1 ||(i != n-1 && s.charAt(i+1) != 'a'))){
                    c = 'a';
                } else if ((i == 0 ||(i != 0 && sb.charAt(i-1) != 'b')) && (i == n-1 ||(i != n-1 && s.charAt(i+1) != 'b'))){
                    c = 'b';
                }else {
                    c = 'c';
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No1576 no1576 = new No1576();
        System.out.println(no1576.modifyString("j?qg??b"));
    }
}
