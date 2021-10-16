package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Shortest Unsorted Continuous Subarray 最短无序连续子数组
 *
 * 思路：先拷贝，然后排序，将两者从前往后，从后往前各比较一次，得到中间变化的长度。
 *
 * Author: Qi
 * Date: 10-16-2021
 */
public class No581 {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] numsCopy = new int[n];
        System.arraycopy(nums, 0, numsCopy, 0, n);
        Arrays.sort(numsCopy);
        int left = 0;
        while (left < n && nums[left] == numsCopy[left] ){
            left++;
        }
        if (left == n) return 0;
        int right = n - 1;
        while (nums[right] == numsCopy[right]){
            right--;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        No581 no581 = new No581();
        System.out.println(no581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
