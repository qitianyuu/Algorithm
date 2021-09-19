package com.qi.algorithm.stringPro;

/**
 * Description: Reverse String 反转字符串
 *
 * 思路：快慢指针，一头一尾，向中间聚集，每次交换
 *
 * Author: Qi
 * Date: 08-26-2021
 */
public class No344 {

    public void reverseString(char[] s) {

        if (s.length == 0){
            return;
        }
        int h,t;
        h = 0;
        t = s.length - 1;
        while (h < t){
            char tmp = s[h];
            s[h] = s[t];
            s[t] = tmp;
            h++;
            t--;
        }
    }

    public static void main(String[] args) {
        No344 no344 = new No344();
        char[] a = {'a','b','c','d'};
        no344.reverseString(a);
        System.out.println(a);
    }
}
