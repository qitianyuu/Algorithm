package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Product of Array Except Self 除自身以外数组的乘积
 *
 * 思路：第 i 个数可以由他左边的乘积和右边的乘积相乘得到
 *      因此循环，得到两个数组，分别记录了从左到右和从右到左的乘积
 *      最后的答案再将两个数组相乘得到
 *
 * Author: Qi
 * Date: 11-09-2021
 */
public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[]left = new int[n];
        int[]right = new int[n];
        left[0] = right[n-1] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] * nums[i-1];
            right[n-i-1] = right[n-i] * nums[n-i];
        }
        for (int i = 0; i < n; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }

    public static void main(String[] args) {
        No238 no238 = new No238();
        System.out.println(Arrays.toString(no238.productExceptSelf(new int[]{1,2,3,4})));
    }
}
