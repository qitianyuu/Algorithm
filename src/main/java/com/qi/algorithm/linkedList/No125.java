package com.qi.algorithm.linkedList;

/**
 * Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 两种思路，一种是反转判断是否相等，另一种是双指针
 * Author: Qi
 * Date: 07-13-2021
 */
public class No125 {

    //采用字符串数组+双指针的处理方式
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head < tail){
            while (!((chars[head] >='a' && chars[head] <= 'z') ||(chars[head] >='0' && chars[head] <= '9'))|| !((chars[tail] >='a' && chars[tail] <= 'z')||(chars[tail] >='0' && chars[tail] <= '9'))){
                if (chars[head] >= 'A' && chars[head] <= 'Z'){
                    chars[head] += 32;
                }else if ((chars[head] >= 'a' && chars[head] <= 'z') || (chars[head] >='0' && chars[head] <= '9')){
                }else {
                    head++;
                }
                if (chars[tail] >= 'A' && chars[tail] <= 'Z'){
                    chars[tail] += 32;
                }else if ((chars[tail] >= 'a' && chars[tail] <= 'z') || (chars[tail] >='0' && chars[tail] <= '9')){
                }else {
                    tail--;
                }
                if (head > chars.length - 1 || tail < 0){
                    return true;
                }
            }
            if (chars[head] == chars[tail]){
                head++;
                tail--;
            }else {
                return false;
            }
        }
        return true;
    }

    //采用stringbuffer+双指针方式
    public boolean isPalindrome1(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i <length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        int head = 0;
        int tail = sb.length() - 1;
        while (head < tail){
            if (sb.charAt(head) == sb.charAt(tail)){
                tail --;
                head ++;
            }else {
                return false;
            }
        }
        return true;
    }

    //采用stringbufer+反转的方式
    public boolean isPalindrome2(String s) {
        StringBuffer sb = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        StringBuffer sbRev = new StringBuffer(sb).reverse();
        return sbRev.toString().equals(sb.toString());
    }


    public static void main(String[] args) {
        No125 no125 = new No125();
        String s = "A man, a plan, a canal: Panama";
        boolean b = no125.isPalindrome2(s);
        System.out.println(b);
    }
}
