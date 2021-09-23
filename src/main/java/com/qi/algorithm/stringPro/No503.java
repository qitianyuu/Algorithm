package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Next Greater Element II 下一个更大元素 II
 *
 * 思路：本题采用单调栈，循环两次得到每个元素的后一个最大元素。
 *
 * Author: Qi
 * Date: 09-22-2021
 */
public class No503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]){
                ans[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ans;
    }

    public static void main(String[] args) {
        No503 no503 = new No503();
        int[] ints = no503.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(ints));

    }
}
