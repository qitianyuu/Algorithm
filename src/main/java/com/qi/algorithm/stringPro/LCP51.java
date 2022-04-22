package com.qi.algorithm.stringPro;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Description: 烹饪料理
 *
 * 思路： dfs暴力解法
 *
 * Author: Qi
 * Date: 2022/4/22
 */
public class LCP51 {

    int max;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        max = -1;
        int cookCount = cookbooks.length;
        int meiweidu = 0;
        int baoshidu = 0;
        // 按照美味度排序，依次做 attribute[i][0]

        int paiming [][] = new int[cookCount][3];

        for (int i = 0; i < cookCount; i++) {
            int mei = attribute[i][0];
            int bao = attribute[i][1];
            paiming[i] = new int[]{i, mei, bao};
        }

        Arrays.sort(paiming, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //return o1[1] - o2[1];
                if (o1[1] != o2[1]){
                    return o2[1] - o1[1];
                }else {
                    return o2[2] - o1[2];
                }
            }
        });

        //已经完成排序，然后开始做
        if(canDo(materials, cookbooks, paiming[0][0])){
            meiweidu += attribute[paiming[0][0]][0];
            baoshidu += attribute[paiming[0][0]][1];
            for (int j = 0; j < 5; j++) {
                materials[j] -= cookbooks[paiming[0][0]][j];
            }
            dfs(0, cookCount, meiweidu, baoshidu, materials, cookbooks, attribute, limit, paiming);
            meiweidu -= attribute[paiming[0][0]][0];
            baoshidu -= attribute[paiming[0][0]][1];
            for (int j = 0; j < 5; j++) {
                materials[j] += cookbooks[paiming[0][0]][j];
            }
        }
        dfs(0, cookCount, meiweidu, baoshidu, materials, cookbooks, attribute, limit, paiming);

        return max;
    }

    private void dfs(int i, int cookCount, int meiweidu, int baoshidu, int[] materials, int[][] cookbooks, int[][] attribute, int limit, int[][] paiming) {
        i = i + 1;
        if (i == cookCount){
            if (baoshidu >= limit && meiweidu >= max){
                max = meiweidu;
            }
            return;
        }
        if(canDo(materials, cookbooks, paiming[i][0])){
            meiweidu += attribute[paiming[i][0]][0];
            baoshidu += attribute[paiming[i][0]][1];
            for (int j = 0; j < 5; j++) {
                materials[j] -= cookbooks[paiming[i][0]][j];
            }
            dfs(i, cookCount, meiweidu, baoshidu, materials, cookbooks, attribute, limit, paiming);
            meiweidu -= attribute[paiming[i][0]][0];
            baoshidu -= attribute[paiming[i][0]][1];
            for (int j = 0; j < 5; j++) {
                materials[j] += cookbooks[paiming[i][0]][j];
            }
        }
        dfs(i, cookCount, meiweidu, baoshidu, materials, cookbooks, attribute, limit, paiming);

    }

    private boolean canDo(int[] materials, int[][] cookbooks, int i) {
        if (materials[0] >= cookbooks[i][0] && materials[1] >= cookbooks[i][1] && materials[2] >= cookbooks[i][2] && materials[3] >= cookbooks[i][3] && materials[4] >= cookbooks[i][4]){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        LCP51 lcp51 = new LCP51();
        int m[] = new int[]{3,2,4,1,2};
        int cook [][] = new int[][]{{1,1,0,1,2}, {2,1,4,0,0}, {3,2,4,1,0}};
        int attr [][] = new int[][]{{3,2},{2,4},{7,6}};
        System.out.println(lcp51.perfectMenu(m, cook, attr, 5));
    }
}
