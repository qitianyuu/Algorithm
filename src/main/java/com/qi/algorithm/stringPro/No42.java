package com.qi.algorithm.stringPro;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Trapping Rain Water 接雨水
 *
 * 思路：维护一个单调栈，使得当前元素低于栈顶元素时，入栈，当高于栈顶元素时，循环找到左边的边界
 *      每次循环计算雨水体积，直到栈空或者找到大于当前元素的左边的元素
 *
 * Author: Qi
 * Date: 11-03-2021
 */
public class No42 {

    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.getLast()] < height[i]){
                int tmp = stack.removeLast();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.getLast();
                int currentWeight = i - left -1;
                int currentHeight = Math.min(height[i], height[left]) - height[tmp];
                ans += currentHeight * currentWeight;
            }
            stack.offer(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        No42 no42 = new No42();
        System.out.println(no42.trap(new int[]{1,0,0,0,1}));
    }
}
