package com.qi.algorithm.stringPro;

/**
 * Description: Maximum Subarray 最大子序和
 *
 * 思路：动态规划，对于后一个状态只和他最接近的前一个有关系的，可以不保存数组，直接每次迭代就行。
 *
 * Author: Qi
 * Date: 10-17-2021
 */
public class No53 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0)return 0;
        int p = 0, max = nums[0];
        for (int num : nums) {
            p = Math.max(p+num, num);
            max = Math.max(p, max);
        }
        return max;
    }

    public static void main(String[] args) {
        No53 no53 = new No53();
        System.out.println(no53.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
