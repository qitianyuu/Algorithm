package com.qi.algorithm.stringPro;

/**
 * Description:
 * Author: Qi
 * Date: 08-25-2021
 */
public class No125_1 {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0){
            return true;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int start = 0;
        int end = sb.length() - 1;
        while (start < end){
            if (sb.charAt(start) != sb.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        No125_1 no125_1 = new No125_1();
        boolean b = no125_1.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(b);
    }
}
