package com.qi.algorithm.stringPro;

import java.util.PriorityQueue;

/**
 * Description: Maximize Sum Of Array After K Negations K 次取反后最大化的数组和
 *
 * 思路：优先队列，每次出队然后加个负号放进去，最后统计和
 *
 * Author: Qi
 * Date: 12-03-2021
 */
public class No1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        int sum = 0;
        for (int num : nums) {
            p.offer(num);
            sum += num;
        }
        for (int i = 0; i < k; i++) {
            int tmp = p.poll();
            p.offer(-tmp);
            sum = sum - 2 * tmp;
        }
        return sum;
    }

    public static void main(String[] args) {
        No1005 no1005 = new No1005();
        System.out.println(no1005.largestSumAfterKNegations(new int[]{1, 6, 3, 5}, 1));
    }

}
