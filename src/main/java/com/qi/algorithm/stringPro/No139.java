package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description: Word Break 单词拆分
 *
 * 思路：采用动态规划的思想，将单词表用集合存起来，然后二重循环遍历
 *      如果找到，就在他的后一位置为 true，则最后看最后一位是否是 true 则可以判断是否能被完成划分
 *
 * Author: Qi
 * Date: 09-28-2021
 */
public class No139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        No139 no139 = new No139();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        boolean leetcode = no139.wordBreak("leetcode", list);
        System.out.println(leetcode);
    }
}
