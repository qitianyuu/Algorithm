package com.qi.algorithm.stringPro;

/**
 * Description: House Robber II 打家劫舍 II
 *
 * 思路：主要就是第一家和最后一家连起来的问题，那么就有两种情况
 *      一是第一家偷，最后一家不偷，二是第一家不偷，最后一家都可以
 *      所以取两种中的最大
 *
 * Author: Qi
 * Date: 12-04-2021
 */
public class No213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robse(nums, 0, n-2), robse(nums, 1, n-1));
    }

    private int robse(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(first, nums[start+1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return Math.max(second, first);
    }

    public static void main(String[] args) {
        No213 no213 = new No213();
        System.out.println(no213.rob(new int[]{1, 2, 3, 1}));
    }
}
