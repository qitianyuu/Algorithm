package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Find First and Last Position of Element in Sorted Array 在排序数组中查找元素的第一个和最后一个位置
 *
 * 思路：从头遍历，找到头和尾，找到尾之后跳出。
 *
 * Author: Qi
 * Date: 09-16-2021
 */
public class No34 {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int begin = -1, end = -1;
        for (int i = 0; i <n ; i++) {
            if (nums[i] == target){
                if (begin == -1)begin = i;
                end = i;
            }
            if (nums[i] > target)break;
        }
        return new int[]{begin, end};
    }

    public static void main(String[] args) {
        No34 no34 = new No34();
        int[] ints = no34.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
