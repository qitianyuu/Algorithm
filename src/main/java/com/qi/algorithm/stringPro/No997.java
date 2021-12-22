package com.qi.algorithm.stringPro;

/**
 * Description: Find the Town Judge 找到小镇的法官
 *
 * 思路：保存一个二维数组，分别保存入度和出度，最后遍历查看入为 n - 1，出为 0 的人
 *
 * Author: Qi
 * Date: 12-22-2021
 */
public class No997 {

    public int findJudge(int n, int[][] trust) {
        int[][] graph = new int[n][2];
        for (int[] ints : trust) {
            graph[ints[0] - 1][0]++;
            graph[ints[1] - 1][1]++;
        }
        for (int i = 0; i < n; i++) {
            if (graph[i][0] == 0 && graph[i][1] == n - 1){
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No997 no997 = new No997();
        System.out.println(no997.findJudge(3, new int[][]{{1, 3}, {2, 3}}));
    }
}
