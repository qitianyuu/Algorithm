package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Detect Squares 检测正方形
 *
 * 思路：首先创建 Map<Integer, Map<Integer, Integer>> map, 其中外层map代表每个 y 的取值中，有哪些 x。内层代表每个 x 有几个。
 *      因此每次先找到输入点相同的 y 的所有点，此时另外两个点的坐标已经知道，因此直接取值即可。
 *
 * Author: Qi
 * Date: 01-26-2022
 */
public class No2013 {

    Map<Integer, Map<Integer, Integer>> map;
    public No2013() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        map.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> tmp = map.get(y);
        tmp.put(x, tmp.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        Map<Integer, Integer> heightNum = map.getOrDefault(y, null);
        if (heightNum == null){
            return 0;
        }else {
            for (Integer xx: heightNum.keySet()) {
                int edge = Math.abs(xx - x);
                int num = heightNum.get(xx);
                if (edge != 0){
                    ans += num * map.getOrDefault(y-edge, new HashMap<>()).getOrDefault(xx, 0) * map.getOrDefault(y-edge, new HashMap<>()).getOrDefault(x, 0);
                    ans += num * map.getOrDefault(y+edge, new HashMap<>()).getOrDefault(xx, 0) * map.getOrDefault(y+edge, new HashMap<>()).getOrDefault(x, 0);
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
