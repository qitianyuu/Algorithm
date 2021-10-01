package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: Course Schedule 课程表
 *
 * 思路：先遍历两遍，记录每个点的边和每个点的入边数量(前置课程)，然后构建队列，将入边为零的入队
 *      然后出队，将以此课程为前置的所有课程入边减一，遇到为零的就入队，直到队空，判断是否都遍历到位了。
 *
 * 笔试真题
 *
 * Author: Qi
 * Date: 09-29-2021
 */
public class No207 {

    // 边 以前置为key、入边指向的点为value
    List<List<Integer>> edges;
    // 入边
    int[] totalInEdges;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        totalInEdges = new int[numCourses];
        for (int[] item : prerequisites) {
            edges.get(item[1]).add(item[0]);
            totalInEdges[item[0]]++;
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (totalInEdges[i] == 0){
                q.offer(i);
            }
        }
        int visited = 0;
        while (!q.isEmpty()){
            visited++;
            int tmp = q.pollFirst();
            for (int item : edges.get(tmp)){
                totalInEdges[item]--;
                if (totalInEdges[item] == 0){
                    q.offer(item);
                }
            }
        }
        return visited == numCourses;
    }

    public static void main(String[] args) {
        No207 no207 = new No207();
        boolean b = no207.canFinish(2, new int[][]{{1, 0}});
        System.out.println(b);
    }
}
