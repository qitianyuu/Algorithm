package com.qi.algorithm.stringPro;

/**
 * Description: Check if Array Is Sorted and Rotated 检查数组是否经排序和轮转得到
 *
 * 思路：先找到最小值，然后从最小值位置开始重排数组，最后检测是否非降序
 *
 * Author: Qi
 * Date: 10-31-2021
 */
public class No1752 {

    public boolean check(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)min = num;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == min){
                boolean b = turn(nums, i);
                if (b) return true;
            }
        }
        return false;
    }

    private boolean turn(int[] nums, int i) {
        int n = nums.length;
        int[] tmp = new int[nums.length];
        for (int j = 0; j < n; j++) {
            tmp[j] = nums[(j+i)%n];
        }
        for (int j = 1; j < n; j++) {
            if (tmp[j] < tmp[j-1])return false;
        }
        return true;
    }


    public static void main(String[] args) {
        No1752 no1752 = new No1752();
        System.out.println(no1752.check(new int[]{3, 4, 5, 1, 2}));
    }
}
