package com.qi.algorithm.stringPro;

/**
 * Description: Rectangle Area 矩形面积
 *
 * 思路：重点是如何计算相交的面积，其中相交部分是
 *      Math.min(ax2, bx2) - Math.max(ax1, bx1) 和 Math.min(ay2, by2) - Math.max(ay1, by1)
 *
 * Author: Qi
 * Date: 11-07-2021
 */
public class No223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2 - ax1) * (ay2 - ay1), area2 = (bx2 - bx1) * (by2 - by1);
        int overlapWidth = Math.min(ax2, bx2) - Math.max(ax1, bx1), overlapHeight = Math.min(ay2, by2) - Math.max(ay1, by1);
        int overlapArea = Math.max(overlapWidth, 0) * Math.max(overlapHeight, 0);
        return area1 + area2 - overlapArea;
    }

    public static void main(String[] args) {
        No223 no223 = new No223();
        System.out.println(no223.computeArea(-2 ,-2 ,2 ,2 ,-1 ,-1 ,1 ,1));
    }
}
