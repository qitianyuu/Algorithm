package com.qi.algorithm.stringPro;

/**
 * Description: Compare Version Numbers 比较版本号
 *
 * 思路：首先切分字符串，注意，点号要转义
 *      然后从头开始循环直到最长的那个结束。
 *
 * Author: Qi
 * Date: 11-18-2021
 */
public class No165 {

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n = Math.max(s1.length, s2.length);
        for (int i = 0; i < n; i++) {
            int tmp1 = 0, tmp2 = 0;
            if (i < s1.length){
                tmp1 = Integer.valueOf(s1[i]);
            }
            if (i < s2.length){
                tmp2 = Integer.valueOf(s2[i]);
            }
            if (tmp1 > tmp2) return 1;
            if (tmp1 < tmp2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        No165 no165 = new No165();
        System.out.println(no165.compareVersion("0.1", "1.1"));
    }
}
