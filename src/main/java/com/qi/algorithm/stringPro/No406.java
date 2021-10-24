package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description: Queue Reconstruction by Height 根据身高重建队列
 *
 * 思路：插入的艺术，先插进去的不被后插进去的影响，二维数组排序，二维数组打印。
 *
 * Author: Qi
 * Date: 10-24-2021
 */
public class No406 {

    public int[][] reconstructQueue(int[][] people) {
        //按第一维降序，第二维升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        No406 no406 = new No406();
        int[][] ints = no406.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
