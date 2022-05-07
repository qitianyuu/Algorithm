package com.qi.algorithm.stringPro;

import java.util.*;

/**
 * Description: Minimum Genetic Mutation 最小基因变化
 *
 * 思路：应用队列，广度优先获取最小路径长度，中间加上判断.
 *
 * Author: Qi
 * Date: 2022/5/7
 */
public class No433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        char []ch = new char[]{'A', 'C', 'T', 'G'};

        if (start.equals(end)){
            return 0;
        }
        if (!set.contains(end)){
            return -1;
        }

        Deque<String> q = new LinkedList<>();
        visited.add(start);
        q.offer(start);
        int step = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.removeFirst();
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < 4; k++) {
                        if (ch[k] != cur.charAt(j)){
                            StringBuffer sb = new StringBuffer(cur);
                            sb.setCharAt(j, ch[k]);
                            String tmp = sb.toString();
                            if (!visited.contains(tmp) && set.contains(tmp)){
                                if (tmp.equals(end)){
                                    return step;
                                }
                                q.offer(tmp);
                                visited.add(tmp);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        No433 n = new No433();
        System.out.println(n.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
