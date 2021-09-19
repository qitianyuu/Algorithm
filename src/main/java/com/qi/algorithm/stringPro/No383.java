package com.qi.algorithm.stringPro;

/**
 * Description: Ransom Note 赎金信
 *
 * 思路：类似242的hash解法
 *
 * Author: Qi
 * Date: 08-26-2021
 */
public class No383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote == null || magazine == null || magazine.length()<ransomNote.length()){
            return false;
        }
        int[] dic = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            dic[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            dic[ransomNote.charAt(i) - 'a']--;
            if (dic[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No383 no383 = new No383();
        boolean b = no383.canConstruct("aa","ab");
        System.out.println(b);
    }
}
