package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Number Of Rectangles That Can Form The Largest Square 可以形成最大正方形的矩形数目
 * Author: Qi
 * Date: 02-04-2022
 */
public class No1725 {

    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = -1;
        for (int[] rectangle : rectangles) {
            int tmp = Math.min(rectangle[0], rectangle[1]);
            maxLen = Math.max(maxLen, tmp);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        return map.get(maxLen);
    }

    public static void main(String[] args) {
        No1725 no1725 = new No1725();
        System.out.println(no1725.countGoodRectangles(new int[][]{{5, 8}, {3, 9}, {5, 12}, {16, 5}}));
    }
}
