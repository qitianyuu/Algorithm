package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Maximum Sum of 3 Non-Overlapping Subarrays 三个无重叠子数组的最大和
 *
 * 思路：先遍历找出k个的和，存到 kSum，然后从左到右和从右到左找出最优解
 *      然后从中间挨个便利，找出最大值
 *
 * Author: Qi
 * Date: 12-08-2021
 */
public class No689 {

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int kSum[] = new int[nums.length + 1 - k];//kSum[p]表示从p开始的k个数字之和
        for (int i = 0; i < k; i++) {
            kSum[0] += nums[i];
        }
        for (int i = 1; i <= nums.length - k; i++) {
            kSum[i] = kSum[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        int leftMax[] = new int[kSum.length];
        int rightMax[] = new int[kSum.length];
        rightMax[kSum.length - 1] = kSum.length - 1;
        for (int i = 1; i < kSum.length; i++) {
            leftMax[i] = kSum[i] > kSum[leftMax[i - 1]] ? i : leftMax[i - 1];
            rightMax[kSum.length - 1 - i] = kSum[kSum.length - 1 - i] >= kSum[rightMax[kSum.length - i]] ? kSum.length - 1 - i : rightMax[kSum.length - i];
        }
        int max3 = 0;
        int[] ans = new int[0];
        for (int i = k; i <= nums.length - 2 * k; i++) {
            if (max3 < kSum[i] + kSum[leftMax[i-k]] + kSum[rightMax[i+k]]){
                ans = new int[]{leftMax[i-k], i, rightMax[i+k]};
                max3 = kSum[i] + kSum[leftMax[i-k]] + kSum[rightMax[i+k]];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No689 no689 = new No689();
        System.out.println(Arrays.toString(no689.maxSumOfThreeSubarrays(new int[]{7,13,20,19,19,2,10,1,1,19}, 3)));
    }

}
