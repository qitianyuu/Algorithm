package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: Sort Array By Parity 按奇偶排序数组
 *
 * 思路：暴力法，直接遍历，遇到奇数就和后面的偶数交换
 *      内置 API 排序法，使用内置 API，设置按照除二取余的大小排序
 *      双指针法，一重循环，从左往右找奇数，从右往左找偶数，交换
 *
 * Author: Qi
 * Date: 10-26-2021
 */
public class No905 {

    // 暴力排序
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1){
                for (int j = i+1; j < n; j++) {
                    if (nums[j] % 2 == 0 || nums[j] == 0){
                        swap(nums, i, j);
                        break;
                    }
                    if (j == n-1 && nums[j] % 2 == 1){
                        return nums;
                    }
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }

    //内置 API 排序
    public int[] sortArrayByParity1(int[] nums) {
        Integer[] a = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        Arrays.sort(a,new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1%2-o2%2;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        return nums;
    }

    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        while (left < right){
            while (left < right && nums[left] % 2 == 0)left++;
            while (left < right && nums[right] % 2 == 1)right--;
            if (left < right){
                swap(nums, left, right);
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        No905 no905 = new No905();
        System.out.println(Arrays.toString(no905.sortArrayByParity2(new int[]{1, 0, 2, 3})));
    }
}
