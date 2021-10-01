package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 * Author: Qi
 * Date: 09-28-2021
 */

//小明是一支武装部队的统帅，现在他得到命令需要攻击一个据点，
// 他需要集结自己的部队出征。
// 他手里一共有n个士兵，第i个士兵的攻击力为a[i]，防守力为b[i]。
// 他希望从这些士兵中挑选一部分士兵出来，使得攻击力的和加上防守力的和最大化，
// 同时部队整体上不能有缺陷，所以攻击力的和不能小于0，防守力的和也不能小于0。
// 如果找不到这样的士兵，小明则亲自出征，攻击力0防守力0。
// 你能帮助小明计算一下部队最终的攻击力防守力和么
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();
        while (sc.hasNext()){
            int n = sc.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int []a = new int[2];
                a[0] = sc.nextInt();
                a[1] = sc.nextInt();
                list.add(a);
            }
            m.process(list);
        }
        //Main m = new Main();
        //List<int[]> list = new ArrayList<>();
        //list.add(new int[]{-5, 7});
        //list.add(new int[]{8, -6});
        //list.add(new int[]{6, -3});
        //list.add(new int[]{2, 1});
        //list.add(new int[]{-8, 5});
        //m.process(list);
    }

    int max;
    private void process(List<int[]> list) {
        if (list.size() == 0){
            System.out.println("0");
            return;
        }
        max = Integer.MIN_VALUE;
        trackback(list, 0, 0, 0, 0);
        System.out.println(max);
    }

    private void trackback(List<int[]> list, int index, int cur, int gong, int fang) {
        if (index == list.size()){
            if (gong < 0 || fang < 0)return;
            max = Math.max(cur, max);
            return;
        }
        //要：
        int a = list.get(index)[0];
        int b = list.get(index)[1];
        trackback(list, index+1, cur+a+b, gong+a, fang+b);
        //不要
        trackback(list, index+1, cur, gong, fang);
    }
}
