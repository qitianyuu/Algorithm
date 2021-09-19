package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: Minimum Number of Arrows to Burst Balloons 用最少数量的箭引爆气球
 *
 * 思路：贪心算法，先按照右边界排序，然后每一次射箭都射在右边界最小的这一个，
 *      这就能保证在射到最左边的一个气球的前提下，尽可能射到右边的气球
 *
 *      同时有一个小细节，写 comparator 时候，不能用两数相减，会有溢出风险
 *
 * Author: Qi
 * Date: 09-17-2021
 */
public class No452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        int arrow = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > arrow){
                arrow = point[1];
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No452 no452 = new No452();
        int ans = no452.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
        System.out.println(ans);
    }
}
