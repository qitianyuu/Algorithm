package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Minimum Moves to Equal Array Elements II 最少移动次数使数组元素相等 II
 *
 * 思路：核心是找到中位数，并以此为基准进行移动，分别计算每个数与中位数的差值，累加即可
 *
 * Author: Qi
 * Date: 09-17-2021
 */
public class No462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(nums[n/2] - num);
        }
        return sum;
    }

    public static void main(String[] args) {
        No462 no462 = new No462();
        int i = no462.minMoves2(new int[]{1, 2, 3});
        System.out.println(i);
    }
}
