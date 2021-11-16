package com.qi.algorithm.stringPro;

import java.util.HashSet;
import java.util.Set;

/**
 * Description: Perfect Rectangle 完美矩形
 *
 * 思路：将所有的点都保存在一个 Set 中，每两个消一次，最后只剩下四个角上的点，且小矩形的面积和等于大矩形
 *
 * Author: Qi
 * Date: 11-16-2021
 */
public class No391 {

    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> set = new HashSet<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MAX_VALUE;
        int top = Integer.MIN_VALUE;
        int sumArea = 0;
        for (int[] rectangle : rectangles) {
            sumArea += (rectangle[2] - rectangle[0]) * (rectangle[3] - rectangle[1]);
            left = Math.min(left, rectangle[0]);
            right = Math.max(right, rectangle[2]);
            bottom = Math.min(bottom, rectangle[1]);
            top = Math.max(top, rectangle[3]);

            String lt = rectangle[0] + " " + rectangle[3];
            String lb = rectangle[0] + " " + rectangle[1];
            String rt = rectangle[2] + " " + rectangle[3];
            String rb = rectangle[2] + " " + rectangle[1];
            if (!set.contains(lt)) {
                set.add(lt);
            }else {
                set.remove(lt);
            }
            if (!set.contains(lb)) {
                set.add(lb);
            }else {
                set.remove(lb);
            }
            if (!set.contains(rt)) {
                set.add(rt);
            }else {
                set.remove(rt);
            }
            if (!set.contains(rb)) {
                set.add(rb);
            }else {
                set.remove(rb);
            }
        }

        if (set.size() == 4 && set.contains(left + " " + top) && set.contains(left + " " + bottom) && set.contains(right + " " + top) && set.contains(right + " " + bottom)){
            return sumArea == (top - bottom) * (right - left);
        }
        return false;
    }

    public static void main(String[] args) {
        No391 no391 = new No391();
        System.out.println(no391.isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
    }
}
