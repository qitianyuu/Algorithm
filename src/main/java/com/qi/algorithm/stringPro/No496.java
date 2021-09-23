package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Next Greater Element I 下一个更大元素 I
 *
 * 思路：单调栈，本题寻找下一个更大元素，可以维护一个单调栈，使得栈中的元素单调递减
 *      这样对于下一个元素，所有小于他的元素的下一个最大元素就找到了。
 *
 * Author: Qi
 * Date: 09-22-2021
 */
public class No496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]){
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        No496 no496 = new No496();
        int[] ints = no496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        System.out.println(Arrays.toString(ints));
    }

}
