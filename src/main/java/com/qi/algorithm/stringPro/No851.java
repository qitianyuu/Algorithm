package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Loud and Rich 喧闹和富有
 *
 * 思路：先构建有向无环图，由钱少的指向钱多的，然后以某一节点出发能达到的所有点的最小值就是这个点的答案
 *      考虑 dfs，并且不重复搜索。
 *
 * Author: Qi
 * Date: 12-15-2021
 */
public class No851 {

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> edges = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] ints : richer) {
            edges.get(ints[1]).add(ints[0]);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            dfs(i, quiet, edges, ans);
        }
        //for (int i = 0; i < n; i++) {
        //    ans[i] = findQuite(i, map, edges, quiet);
        //}
        return ans;
    }

    private void dfs(int i, int[] quiet, List<List<Integer>> edges, int[] ans) {
        if (ans[i] != -1)return;
        ans[i] = i;
        for (int y : edges.get(i)) {
            dfs(y, quiet, edges, ans);
            if (quiet[ans[y]] < quiet[ans[i]]) {
                ans[i] = ans[y];
            }
        }
    }

    private int findQuite(int i, Map<Integer, Integer> map, List<List<Integer>> edges, int[] quite) {
        if (map.containsKey(i)) return map.get(i);
        Deque<Integer> q = new LinkedList<>();
        for (Integer integer : edges.get(i)) {
            q.offer(integer);
        }
        int minQuite = Integer.MAX_VALUE;
        int minIdx = i;
        while (!q.isEmpty()){
            int tmp = q.pollFirst();
            if (minQuite > quite[tmp]){
                minQuite = quite[tmp];
                minIdx = tmp;
            }
            for (Integer integer : edges.get(tmp)) {
                q.offer(integer);
            }
        }
        if (minQuite > quite[i]){
            minQuite = quite[i];
            minIdx = i;
        }
        map.put(i, minQuite);
        return minIdx;
    }

    public static void main(String[] args) {
        No851 no851 = new No851();
        System.out.println(Arrays.toString(no851.loudAndRich(new int[][]{{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}}, new int[]{3, 2, 5, 4, 6, 1, 7, 0})));
    }
}
