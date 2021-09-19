package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Number of Boomerangs 回旋镖的数量
 *
 * 思路：没啥技巧，二重循环，针对每个点计算其与其他点的距离，然后距离相同则为一个回旋镖
 *      这里注意 map 的 getOrDefault 操作。
 *
 * Author: Qi
 * Date: 09-16-2021
 */
public class No447 {

    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int[] x : points){
            map.clear();
            for (int[] y : points) {
                int d = (int) (Math.pow(x[0]-y[0], 2) + Math.pow(x[1]-y[1], 2));
                int tmp = map.getOrDefault(d, 0);
                ans += tmp << 1;
                map.put(d, tmp + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No447 no447 = new No447();
        int i = no447.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}});
        System.out.println(i);
    }
}
