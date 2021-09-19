package com.qi.algorithm.stringPro;

/**
 * Description: Container With Most Water 盛最多水的容器
 *
 * 思路：本题经典双指针问题，通过一左一右两个指针进行不断的往中间移动，记录最大值。
 *      每次移动较小的那个值。
 *
 * Author: Qi
 * Date: 09-16-2021
 */
public class No11 {

    //暴力解法 耗时
    public int maxArea(int[] height) {
        int n = height.length;
        int max = Integer.MIN_VALUE;
        int tmp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                tmp = Math.min(height[i], height[j]) * Math.abs(j - i);
                if (max < tmp) max = tmp;
            }
        }
        return max;
    }

    //双指针
    public int maxArea1(int[] height) {
        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right){
            int tmp = Math.min(height[left], height[right]) * (right - left);
            if (tmp > max) max = tmp;
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        No11 no11 = new No11();
        int i = no11.maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
