package com.qi.algorithm.stringPro;

/**
 * Description:  Implement strStr() 实现 strStr()
 * Author: Qi
 * Date: 08-23-2021
 */
public class No28 {

    //暴力解法
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
            return -1;
        }
        if (needle.length() == 0){
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();
        if (m == n){
            return haystack.equals(needle) ? 0 : -1;
        }
        for (int i = 0; i < m - n + 1; i++) {
            String str = haystack.substring(i, i + n);
            if (str.equals(needle)){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        No28 no28 = new No28();
        int ans = no28.strStr("abc", "c");
        System.out.println(ans);
        System.out.println("abc".indexOf("c"));
    }
}
