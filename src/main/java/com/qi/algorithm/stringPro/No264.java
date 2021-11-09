package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Ugly Number II 丑数 II
 *
 * 思路：重点是如何生成丑数，就是从1开始，依次乘 2、3、5，加入优先队列不断乘。
 *
 * Author: Qi
 * Date: 11-09-2021
 */
public class No264 {

    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue();
        set.add(1L);
        pq.offer(1L);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Long tmp = pq.poll();
            ans = Math.toIntExact(tmp);
            if (set.add(tmp * 2)){
                pq.offer(tmp * 2);
            }
            if (set.add(tmp * 3)){
                pq.offer(tmp * 3);
            }
            if (set.add(tmp * 5)){
                pq.offer(tmp * 5);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No264 no264 = new No264();
        System.out.println(no264.nthUglyNumber(10));
    }
}
