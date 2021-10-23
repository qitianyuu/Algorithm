package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Daily Temperatures 每日温度
 *
 * 思路：单调栈解法，维护一个单调栈，假如后一天的气温比栈顶的低，那就入栈
 *      假如比栈顶高，则栈顶出栈，此时已经找到了比栈顶气温高的日期，写入答案
 *      然后循环往复，直到队空或者栈顶比当前气温高，然后入栈。
 *      始终保持栈中元素从顶到底单调递增。
 *
 * Author: Qi
 * Date: 10-23-2021
 */
public class No739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        if (n == 1)return new int[]{0};
        int[] ans = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getLast()]){
                int tmp = stack.removeLast();
                ans[tmp] = i-tmp;
            }
            stack.offer(i);
        }
        while (!stack.isEmpty()){
            int tmp = stack.removeLast();
            ans[tmp] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        No739 no739 = new No739();
        int[] ints = no739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}
