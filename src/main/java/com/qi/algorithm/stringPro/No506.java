package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Relative Ranks 相对名次
 *
 * 思路：排序加检索
 *
 * Author: Qi
 * Date: 12-02-2021
 */
public class No506 {

    public String[] findRelativeRanks(int[] score) {
        int[] scoreCopy = score.clone();
        int n = score.length;
        Arrays.sort(score);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int a = scoreCopy[i];
                for (int j = n - 1; j >= 0; j--) {
                if (a == score[j]){
                    if (j == n - 1){
                        ans[i] = "Gold Medal";
                    }else if (j == n - 2){
                        ans[i] = "Silver Medal";
                    }else if (j == n - 3){
                        ans[i] = "Bronze Medal";
                    }else {
                        ans[i] = String.valueOf(n - j);
                    }
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No506 no506 = new No506();
        String[] ans = no506.findRelativeRanks(new int[]{10, 3, 8, 9, 4});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
