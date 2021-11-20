package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Longest Harmonious Subsequence 最长和谐子序列
 * Author: Qi
 * Date: 11-20-2021
 */
public class No594 {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0, res = 0;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] - nums[left] > 1){
                left++;
            }
            if (nums[right] - nums[left] == 1){
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No594 no594 = new No594();
        System.out.println(no594.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
