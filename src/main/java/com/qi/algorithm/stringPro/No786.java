package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: K-th Smallest Prime Fraction 第 K 个最小的素数分数
 *
 * 思路：暴力法，构造list，重写排序方法，然后返回第 k 个元素。
 *      优先队列，从每个元素的 arr[0] / arr[i] 开始，初始队列有 n-1 个元素
 *      不断poll，并且新加入，直到第 k 个出队的就是答案。
 *
 * Author: Qi
 * Date: 11-29-2021
 */
public class No786 {

    //暴力解法
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new int[]{arr[i], arr[j]});
            }
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] * o2[1] - o2[0] * o1[1];
            }
        });
        return list.get(n-k+1);
    }

    //优先队列
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return arr[o1[0]] * arr[o2[1]] - arr[o2[0]] * arr[o1[1]];
            }
        });
        for (int i = 1; i < n; i++) {
            pq.offer(new int[]{0, i});
        }
        for (int i = 1; i < k; i++) {
            int[] tmp = pq.poll();
            int x = tmp[0], y = tmp[1];
            if (x + 1 < y){
                pq.offer(new int[]{x+1, y});
            }
        }
        return new int[]{arr[pq.peek()[0]], arr[pq.peek()[1]]};
    }

    public static void main(String[] args) {
        No786 no786 = new No786();
        System.out.println(Arrays.toString(no786.kthSmallestPrimeFraction1(new int[]{1, 2, 3, 5}, 3)));
    }
}
