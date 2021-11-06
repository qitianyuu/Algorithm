package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Missing Number 丢失的数字
 *
 * 思路：排序后检查 nnums[i] 是否等于 i
 *
 * Author: Qi
 * Date: 11-06-2021
 */
public class No268 {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] != i){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No268 no268 = new No268();
        System.out.println(no268.missingNumber(new int[]{3, 0, 1}));
    }
}
