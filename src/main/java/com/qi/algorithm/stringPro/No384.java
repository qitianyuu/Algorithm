package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Random;

/**
 * Description: Shuffle an Array 打乱数组
 *
 * 思路：主要是打乱的方法，生成随机数，并且随即交换
 *
 * Author: Qi
 * Date: 11-22-2021
 */
public class No384 {
    int[] ans;
    int []original;
    public No384(int[] nums) {
        ans = nums;
        original = new int[nums.length];
        System.arraycopy(ans, 0,original, 0, nums.length);
    }

    public int[] reset() {
        System.arraycopy(original, 0, ans, 0,ans.length);
        return ans;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < ans.length; i++) {
            int j = i + random.nextInt(ans.length - i);
            int tmp = ans[i];
            ans[i] = ans[j];
            ans[j] = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        No384 no384 = new No384(new int[]{1, 2, 3});
        int[] a = no384.shuffle();
        System.out.println(Arrays.toString(a));

        a = no384.reset();
        System.out.println(Arrays.toString(a));
        a = no384.shuffle();
        System.out.println(Arrays.toString(a));
    }
}
