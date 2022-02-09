package com.qi.algorithm.stringPro;

/**
 * Description: Count Number of Pairs With Absolute Difference K 差的绝对值为 K 的数对数目
 * Author: Qi
 * Date: 02-09-2022
 */
public class No2006 {

    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No2006 no2006 = new No2006();
        System.out.println(no2006.countKDifference(new int[]{1, 2, 2, 1}, 1));
    }
}
