package com.qi.algorithm.stringPro;

/**
 * Description: Buddy Strings 亲密字符串
 *
 * 思路：如果长度不等返回 false
 *      如果相等且有重复字母返回 True
 *      如果只有两个不同且两个互换后相等则返回 True
 *      否则返回 False
 *
 * Author: Qi
 * Date: 11-23-2021
 */
public class No859 {

    public boolean buddyStrings(String s, String goal) {
        int ans = 0;
        if (s.length() != goal.length())return false;
        if (s.equals(goal) && isSame(s))return true;
        int [] a = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                ans++;
                if (ans > 2)return false;
                a[ans-1] = i;
            }
        }
        return ans == 2 && s.charAt(a[0]) == goal.charAt(a[1]) && s.charAt(a[1]) == goal.charAt(a[0]);
    }

    private boolean isSame(String s) {
        int[] tmp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (tmp[Character.toLowerCase(s.charAt(i)) - 'a'] == 0){
                tmp[Character.toLowerCase(s.charAt(i)) - 'a']++;
            }else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        No859 no859 = new No859();
        System.out.println(no859.buddyStrings("ab", "ba"));
    }
}
