package com.qi.algorithm.stringPro;

/**
 * Description: Count Special Quadruplets 统计特殊四元组
 *
 * 思路：暴力、还可以用 hash 表，可以减少一层循环。
 *
 * Author: Qi
 * Date: 12-29-2021
 */
public class No1995 {

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No1995 no1995 = new No1995();
        System.out.println(no1995.countQuadruplets(new int[]{1, 2, 3, 6}));
    }
}
