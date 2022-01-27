package com.qi.algorithm.stringPro;

/**
 * Description: Number of Valid Words in a Sentence 句子中的有效单词数
 * Author: Qi
 * Date: 01-27-2022
 */
public class No2047 {

    public int countValidWords(String sentence) {
        String[] strs = sentence.trim().split(" ");
        int ans = 0;
        for (String str : strs) {
            String tmp = str.trim();
            if (!tmp.equals("") && isToken(tmp)){
                ans++;
            }
        }
        return ans;
    }

    private boolean isToken(String str) {
        if (str.length() == 1 && (str.equals(".") || str.equals(",") || str.equals("!"))){
            return true;
        }
        int containHyphen = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && !Character.isLetter(str.charAt(i))){
                return false;
            }
            if (i == str.length() - 1 && str.charAt(i) == '-'){
                return false;
            }
            if (Character.isDigit(str.charAt(i))){
                return false;
            }
            if (str.charAt(i) == '-'){
                if (containHyphen != 0) return false;
                containHyphen++;
                if (!(Character.isLetter(str.charAt(i-1)) && Character.isLetter(str.charAt(i+1)))){
                    return false;
                }else {
                    continue;
                }
            }
            if (i != str.length() - 1 && !Character.isLetter(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No2047 no2047 = new No2047();
        System.out.println(no2047.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }
}
