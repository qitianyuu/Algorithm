package com.qi.algorithm.stringPro;

/**
 * Description: Elimination Game 消除游戏
 *
 * 思路：最后剩下一个意味着只要记录每次迭代的第一个，直到剩余只有一个则就能得到答案
 *      因此只记录第一个数是啥，加入第一个数被删掉了，则往后走step步
 *
 * Author: Qi
 * Date: 01-02-2022
 */
public class No390 {

    public int lastRemaining(int n) {
        int now = n, ans = 1, step = 1;
        boolean flag = true;
        while (now > 1){
            if (flag || now % 2 == 1){
                ans += step;
            }
            flag = !flag;
            now /= 2;
            step *= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        No390 no390 = new No390();
        System.out.println(no390.lastRemaining(9));
    }
}
