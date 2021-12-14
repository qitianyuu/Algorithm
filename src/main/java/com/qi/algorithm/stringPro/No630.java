package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description: Course Schedule III 课程表 III
 *
 * 思路：贪心策略，先按照结束时间的升序排列，然后逐个添加，当添加第 i 个时候，看一下添加后是否超出 i 的最晚时间
 *      若超出，判断之前所有课程中的最长耗时课程是否比 i 长，如果是，则替换，替换后一定更优。
 *
 * Author: Qi
 * Date: 12-14-2021
 */
public class No630 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        int total = 0;
        for (int[] course : courses) {
            int dur = course[0], dl = course[1];
            if (total + dur <= dl){
                total += dur;
                q.offer(dur);
            }else if (!q.isEmpty() && q.peek() > dur){
                total -= q.poll();
                total += dur;
                q.offer(dur);
            }
        }
        return q.size();
    }

    public static void main(String[] args) {
        No630 no630 = new No630();
        System.out.println(no630.scheduleCourse(new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}));
    }
}
