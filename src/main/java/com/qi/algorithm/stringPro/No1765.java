package com.qi.algorithm.stringPro;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description: Map of Highest Peak 地图中的最高点
 *
 * 思路：通过队列实现，先将水面入队，然后依次循环，每次循环队列 size 次， 每次循环代表一层高度。
 *
 * Author: Qi
 * Date: 01-29-2022
 */
public class No1765 {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] ans = new int[m][n];
        int[][] visited = new int[m][n];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1){
                    q.offer(new int[]{i, j});
                    ans[i][j] = 0;
                    visited[i][j] = 1;
                }
            }
        }
        while (!q.isEmpty()){
            int tmp = q.size();
            for (int i = 0; i < tmp; i++) {
                int []tmpDot = q.removeFirst();
                //循环他周围的四个
                for (int j = 0; j < 4; j++) {
                    int tmpx = tmpDot[0] + dx[j];
                    int tmpy = tmpDot[1] + dy[j];
                    if (tmpx < 0 || tmpx > m - 1 || tmpy < 0 || tmpy > n - 1) continue;
                    if (visited[tmpx][tmpy] != 1){
                        visited[tmpx][tmpy] = 1;
                        ans[tmpx][tmpy] = ans[tmpDot[0]][tmpDot[1]] + 1;
                        q.offer(new int[]{tmpx, tmpy});
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No1765 no1765 = new No1765();
        System.out.println(no1765.highestPeak(new int[][]{{0, 0}, {1, 1}, {1, 0}}));
    }
}
