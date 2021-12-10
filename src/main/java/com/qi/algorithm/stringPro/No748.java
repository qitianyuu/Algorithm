package com.qi.algorithm.stringPro;

/**
 * Description: Shortest Completing Word 最短补全词
 *
 * 思路：没有思路，今天被傻逼力扣的网站恶心死了，半小时就会转圈，啥啥都加载不出来
 *
 * Author: Qi
 * Date: 12-10-2021
 */
public class No748 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                ++cnt[Character.toLowerCase(ch) - 'a'];
            }
        }
        int idx = -1;
        for (int i = 0; i < words.length; ++i) {
            int[] c = new int[26];
            for (int j = 0; j < words[i].length(); ++j) {
                char ch = words[i].charAt(j);
                ++c[ch - 'a'];
            }
            boolean ok = true;
            for (int j = 0; j < 26; ++j) {
                if (c[j] < cnt[j]) {
                    ok = false;
                    break;
                }
            }
            if (ok && (idx < 0 || words[i].length() < words[idx].length())) {
                idx = i;
            }
        }
        return words[idx];
    }

    public static void main(String[] args) {
        No748 no748 = new No748();
        System.out.println(no748.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }
}
