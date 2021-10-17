package com.qi.algorithm.stringPro;

/**
 * Description: Maximum Product Subarray 乘积最大子数组
 *
 * 思路：动态规划，这个题和 No.53 类似，那个是加法，这个是乘法，需要考虑负数乘负数的情况
 *      因此维护两个数组，分别保存最大和最小，重要的是如何找状态转移方程。
 *      最大有可能是本身，或者自身乘上一个的最大(本身是正数)，或者自身乘上一个的最小(本身是负数)
 *
 * Author: Qi
 * Date: 10-17-2021
 */
public class No152 {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i-1], nums[i] * min[i-1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i-1], nums[i] * min[i-1]));
        }
        int ans = max[0];
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, max[i]);
            ans = Math.max(ans, min[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        No152 no152 = new No152();
        System.out.println(no152.maxProduct(new int[]{2, 3, -2, 4}));
    }
}
