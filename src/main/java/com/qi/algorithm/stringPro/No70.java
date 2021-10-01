package com.qi.algorithm.stringPro;

/**
 * Description: Climbing Stairs 爬楼梯
 *
 * 思路：凡是找出全部可能的，都可以用回溯法，但是本题会超时
 *      动态规划：由题可知，上到第 k 级台阶的方法数是由 k-1 和 k-2 的方法数累加得到
 *      因此，动态规划即可，由于是一位数组，因此可以用滚动数组，即三个元素循环滚动。
 *
 * Author: Qi
 * Date: 09-30-2021
 */
public class No70 {

    // 递归超时
    int ans;
    public int climbStairs(int n) {
        ans = 0;
        dfs(n,0);
        return ans;
    }

    private void dfs(int n, int cur) {
        if (cur == n){
            ans++;
            return;
        }else if (cur > n){
            return;
        }else {
            dfs(n, cur+1);
            dfs(n, cur+2);
        }
    }

    // 动态规划
    public int climbStairs1(int n) {
        int p, q = 0, ans = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = ans;
            ans = p + q;
        }
        return ans;
    }

    public static void main(String[] args) {
        No70 no70 = new No70();
        int i = no70.climbStairs1(3);
        System.out.println(i);
    }

}
