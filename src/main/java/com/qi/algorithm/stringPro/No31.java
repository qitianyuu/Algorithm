package com.qi.algorithm.stringPro;

import java.util.Arrays;

/**
 * Description: Next Permutation 下一个排列
 *
 * 思路：关键是如何理解下一个最小的数
 *      从后往前遍历，找到第一个当前位数小于后面位数的值，然后再从后往前遍历
 *      找到第一个大于当前的数，交换并重新对第一个数后面的位数进行排序
 *
 * Author: Qi
 * Date: 10-10-2021
 */
public class No31 {

    public void nextPermutation(int[] nums) {
        int i1 = nums.length - 2;
        while (i1 >=0 && nums[i1] >= nums[i1+1]){
            i1--;
        }
        if (i1 >= 0){
            int i2 = nums.length - 1;
            while (nums[i2] <= nums[i1] && i2 > i1){
                i2--;
            }
            int tmp = nums[i1];
            nums[i1] = nums[i2];
            nums[i2] = tmp;
        }

    //    交换 i1 后面的各个位数
        reverse(nums,i1+1);


    }

    private void reverse(int[] nums, int i) {
        int left = i,right = nums.length - 1;
        int tmp;
        while(left < right){
            tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        No31 no31 = new No31();
        int[] n = new int[]{5,1,1};
        no31.nextPermutation(n);
        System.out.println(Arrays.toString(n));
    }
}
