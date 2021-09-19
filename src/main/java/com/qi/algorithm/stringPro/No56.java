package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:  Merge Intervals 合并区间
 *
 * 思路：二维数组排序，打印。
 *
 * Author: Qi
 * Date: 09-14-2021
 */
public class No56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)return new int[0][2];

        //这是难点
        //Arrays.sort(intervals, new Comparator<int[]>() {
        //    @Override
        //    public int compare(int[] o1, int[] o2) {
        //        return o1[0] - o2[0];
        //    }
        //});
        //也可以写成下面这样
        Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0]);

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0], right = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size()-1)[1] < left){
                ans.add(new int[]{left, right});
            }else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        No56 no56 = new No56();
        int[][] merge = no56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
