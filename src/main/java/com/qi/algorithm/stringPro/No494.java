package com.qi.algorithm.stringPro;

/**
 * Description: Target Sum 目标和
 *
 * 思路：对于找出所有可能的问题都可以用回溯法
 *      本题采用回溯法，分别回溯加或者减两种情况。
 *
 * Author: Qi
 * Date: 09-19-2021
 */
public class No494 {

    int ans;

    public int findTargetSumWays(int[] nums, int target) {
        ans = 0;
        int cur = 0;
        if (nums.length == 0)return ans;
        trackback(nums, target, 0, cur);
        return ans;
    }

    private void trackback(int[] nums, int target, int index, int cur) {
        if (index == nums.length){
            if (cur == target){
                ans++;
            }
            return;
        }
        trackback(nums, target, index + 1, cur + nums[index]);
        trackback(nums, target, index + 1, cur - nums[index]);
    }

    public static void main(String[] args) {
        No494 no494 = new No494();
        int ans = no494.findTargetSumWays(new int[]{1}, 1);
        System.out.println(ans);
    }
}
