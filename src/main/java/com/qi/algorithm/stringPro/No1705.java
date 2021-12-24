package com.qi.algorithm.stringPro;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: Maximum Number of Eaten Apples 吃苹果的最大数目
 *
 * 思路：主要是优先队列的使用，贪心算法，每次都吃最快过期的苹果。
 *
 * Author: Qi
 * Date: 12-24-2021
 */

public class No1705 {

    public int eatenApples(int[] apples, int[] days) {
        int ans = 0, n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            // 删除掉过期的
            while (!pq.isEmpty() && pq.peek()[0] <= i){
                pq.poll();
            }
            int dl = days[i] + i;
            int appNum = apples[i];
            if (appNum > 0){
                pq.offer(new int[]{dl, appNum});
            }
            if (!pq.isEmpty()) {
                int tmp[] = pq.peek();
                tmp[1]--;
                if (tmp[1] == 0) pq.poll();
                ans++;
            }
        }
        // 处理后面的苹果
        int day = n;
        while (!pq.isEmpty()){
            while (!pq.isEmpty() && pq.peek()[0] <= day){
                pq.poll();
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] tmp = pq.poll();
            int cur = Math.min(tmp[0] - day, tmp[1]);
            ans += cur;
            day += cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        No1705 no1705 = new No1705();
        System.out.println(no1705.eatenApples(new int[]{1, 2, 3, 5, 2}, new int[]{3, 2, 1, 4, 2}));
    }
}
