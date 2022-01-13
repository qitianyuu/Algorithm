package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Largest Number At Least Twice of Others 至少是其他数字两倍的最大数
 *
 * 思路：排序然后判断
 *
 * Author: Qi
 * Date: 01-13-2022
 */
public class No747 {

    public int dominantIndex(int[] nums) {
        int[] tmp = nums.clone();
        int n = nums.length;
        Arrays.sort(nums);
        if (nums.length < 2)return 0;
        if (nums[n-1] >= nums[n-2] * 2){
            int tmp1 = -1;
            for (int i = 0; i < n; i++) {
                if (tmp[i] == nums[n-1]){
                    tmp1 = i;
                    break;
                }
            }
            return tmp1;
        }else return -1;
    }

    public static void main(String[] args) {
        No747 no747 = new No747();
        System.out.println(no747.dominantIndex(new int[]{3, 6, 1, 0}));
    }
}
