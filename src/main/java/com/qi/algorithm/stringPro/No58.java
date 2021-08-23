package com.qi.algorithm.stringPro;

/**
 * Description:  Length of Last Word 最后一个单词的长度
 *
 * 思路：先去掉最后一个空格，然后再从后向前遍历找到第一个空格或者走到开头
 *
 * Author: Qi
 * Date: 08-23-2021
 */
public class No58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        String s1 = s.trim();
        int ans = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            if (s1.charAt(i) == ' '){
                return ans;
            }
            else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No58 no58 = new No58();
        int ans = no58.lengthOfLastWord("   fly me   to   the moon  ");
        System.out.println(ans);
    }
}
