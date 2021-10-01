package com.qi.algorithm.stringPro;

/**
 * Description: Jump Game 跳跃游戏
 *
 * 思路：贪心算法，每次都到最右边的位置，判断一个点是否可达通过右边最大值判断
 *      相当于涂色，一个队列从左往右涂色，每次都取最大的右边界涂色。
 *
 * Author: Qi
 * Date: 09-29-2021
 */
public class No55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMax = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMax){
                rightMax = Math.max(rightMax, nums[i] + i);
                if (rightMax >= n - 1)return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No55 no55 = new No55();
        boolean b = no55.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(b);
    }

}
