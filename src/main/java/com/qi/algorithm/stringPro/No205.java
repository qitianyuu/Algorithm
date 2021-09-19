package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Isomorphic Strings 同构字符串
 * Author: Qi
 * Date: 08-25-2021
 */
public class No205 {

    //通过对每一个串进行编码的形式取得其模式
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        int count_s = -1;
        int count_t = -1;
        StringBuffer sp1 = new StringBuffer();
        StringBuffer sp2 = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.substring(i,i+1)+"_s")){
                count_s++;
                map.put(s.substring(i,i+1)+"_s",count_s);
            }
            sp1.append(map.get(s.substring(i,i+1)+"_s")).append("、");

            if (!map.containsKey(t.substring(i,i+1)+"_t")){
                count_t++;
                map.put(t.substring(i,i+1)+"_t",count_t);
            }
            sp2.append(map.get(t.substring(i,i+1)+"_t")).append("、");
        }
        return sp1.toString().equals(sp2.toString());
    }

    //将s映射到t 查看是否一致
    public boolean isIsomorphic1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)){
                if (map.get(c1) != c2){
                    return false;
                }
            } else {
              map.put(c1, c2);
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t){
        return isIsomorphic1(s,t) && isIsomorphic1(t,s);
    }

    public static void main(String[] args) {
        No205 no205 = new No205();
        //boolean b = no205.isIsomorphic2("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck");
        boolean b = no205.isIsomorphic2("adda", "egge");
        System.out.println(b);
    }

}
