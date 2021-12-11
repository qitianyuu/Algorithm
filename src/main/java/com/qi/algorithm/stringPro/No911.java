package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: Online Election 在线选举
 *
 * 思路：主要是怎么每次拿到当前时间点的最优
 *      思路是遍历每个时间点，然后维护一个tops List， 每次判断加上当前选票的结果和top的值，大于等于则替换。
 *
 * Author: Qi
 * Date: 12-11-2021
 */
public class No911 {

    static class TopVotedCandidate {

        List<Integer> tops;
        Map<Integer, Integer> voteCounts;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
            tops = new ArrayList<>();
            voteCounts = new HashMap<>();
            voteCounts.put(-1, -1);
            int top = -1;
            for (int i = 0; i < persons.length; ++i) {
                int p = persons[i];
                voteCounts.put(p, voteCounts.getOrDefault(p, 0) + 1);
                if (voteCounts.get(p) >= voteCounts.get(top)) {
                    top = p;
                }
                tops.add(top);
            }
            this.times = times;
        }

        public int q(int t) {
            int l = 0, r = times.length - 1;
            // 找到满足 times[l] <= t 的最大的 l
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (times[m] <= t) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            return tops.get(l);
        }

    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0, 1, 1, 0, 0, 1, 0}, new int[]{0, 5, 10, 15, 20, 25, 30});
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));
    }
}
