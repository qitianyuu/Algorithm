package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: Insert Interval 插入区间
 *
 * 思路：通过分析得出若无交叉区间则无需处理，存在交叉区间则合二为一。
 *      考虑用 list 存储，最后转成数组，针对二维数组排序即可。
 *
 * Author: Qi
 * Date: 09-15-2021
 */
public class No57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (!hasCrossover(intervals[i], newInterval)){
                list.add(intervals[i]);
            }else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        list.add(newInterval);

        int[][]ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        return ans;
    }

    private boolean hasCrossover(int[] interval, int[] newInterval) {
        if (interval[0] > newInterval[1] || interval[1] < newInterval[0]){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        No57 no57 = new No57();
        int[][] insert = no57.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int i = 0; i < insert.length; i++) {
            System.out.println(Arrays.toString(insert[i]));
        }
    }
}
