package com.qi.algorithm.stringPro;
/**
 * Description: Repeated String Match 重复叠加字符串匹配
 *
 * 思路：先增加到 a 比 b 长，然后最多就是一头一尾加两个
 *
 * Author: Qi
 * Date: 12-22-2021
 */
public class No686 {

    public int repeatedStringMatch(String a, String b) {
        if (b.equals(""))return 0;
        int k = b.length() / a.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k; i++) {
            sb.append(a);
        }
        for (int i = 0; i < 3; i++) {
            if (sb.toString().contains(b)) {
                return k + i;
            }
            sb.append(a);
        }
        return -1;
    }

    public static void main(String[] args) {
        No686 no686 = new No686();
        System.out.println(no686.repeatedStringMatch("abcd", "cdabcdab"));
    }
}
