package com.qi.algorithm.stringPro;

/**
 * Description: Find Nearest Point That Has the Same X or Y Coordinate 找到最近的有相同 X 或 Y 坐标的点
 *
 * 思路：循环 points，找出最小的距离的点
 *
 * Author: Qi
 * Date: 11-04-2021
 */
public class No1779 {

    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = Integer.MAX_VALUE, flag = -1;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if ((point[0] == x || point[1] == y) && (ans > Math.abs(point[0]-x)+Math.abs(point[1]-y))){
                ans = Math.abs(point[0]-x)+Math.abs(point[1]-y);
                flag = i;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        No1779 no1779 = new No1779();
        System.out.println(no1779.nearestValidPoint(3, 4, new int[][]{{3, 4}}));
    }
}
