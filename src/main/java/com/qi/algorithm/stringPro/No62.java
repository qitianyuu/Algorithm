package com.qi.algorithm.stringPro;

/**
 * Description: Unique Paths 不同路径
 * Author: Qi
 * Date: 09-14-2021
 */
public class No62 {

    //回溯算法，递归次次数太多
    int ans = 0;
    public int uniquePaths(int m, int n) {
        int curi = 0, curj = 0;
        int []dx = new int[]{0, 1};
        int []dy = new int[]{1, 0};
        trackback(curi, curj, dx, dy, m, n);
        return ans;
    }

    private void trackback(int curi, int curj, int[] dx, int[] dy, int m, int n) {
        if (curi == m-1 && curj == n-1){
            ans++;
            return;
        }else {
            for (int i = 0; i < 2; i++) {
                int tmpcuri = curi + dx[i];
                int tmpcurj = curj + dy[i];
                if (tmpcuri>= 0 && tmpcuri <m && tmpcurj >= 0 && tmpcurj < n){
                    trackback(tmpcuri, tmpcurj, dx, dy, m, n);
                }
            }
        }
    }

    //动态规划 划分子问题
    public int uniquePaths1(int m, int n) {
        int [][]ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i-1][j] + ans[i][j - 1];
            }
        }
        return ans[m-1][n-1];

    }
    public static void main(String[] args) {
        No62 no62 = new No62();
        System.out.println(no62.uniquePaths1(23, 12));
    }
}
