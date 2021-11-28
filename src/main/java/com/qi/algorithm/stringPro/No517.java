package com.qi.algorithm.stringPro;

/**
 * Description: Super Washing Machines 超级洗衣机
 *
 * 思路：化繁为简，直接考虑初始状态和末尾状态，初始状态第i个洗衣机左边总数已知
 *      末状态总数已知，因此 对于第i个洗衣机，移动总数就是左边衣服初始同末尾的差值加上
 *      右边衣服总数初始同末尾的差值之和。
 *
 * Author: Qi
 * Date: 11-28-2021
 */
public class No517 {

    public int findMinMoves(int[] machines) {
        int sum = 0, n = machines.length;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % n != 0)return -1;
        int t = sum / n;
        int leftSum = 0, rightSum = sum, ans = 0;
        for (int i = 0; i < n; i++) {
            rightSum -= machines[i];
            int a = Math.max(0, i * t - leftSum);
            int b = Math.max(0, (n - i - 1) * t - rightSum);
            ans = Math.max(a + b, ans);
            leftSum += machines[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        No517 no517 = new No517();
        System.out.println(no517.findMinMoves(new int[]{1, 0, 5}));
    }
}
