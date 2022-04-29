package com.qi.algorithm.stringPro;

import com.qi.algorithm.entity.Node4;

import java.util.Arrays;

/**
 * Description: Construct Quad Tree 建立四叉树
 *
 * 思路: 递归思想
 *
 * Author: Qi
 * Date: 2022/4/29
 */

public class No427 {


    public Node4 construct(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1){
            return new Node4(grid[0][0] == 1, true);
        }

        if (isAllSame(grid)){
            return new Node4(grid[0][0] == 1, true);
        }

        int len = grid.length;
        int[][] gridTL = new int[len/2][len/2];
        int[][] gridTR = new int[len/2][len/2];
        int[][] gridBL = new int[len/2][len/2];
        int[][] gridBR = new int[len/2][len/2];
        for (int i = 0; i < len/2; i++) {
            System.arraycopy(grid[i], 0, gridTL[i], 0, len/2);
            System.arraycopy(grid[i], len/2, gridTR[i], 0, len/2);
        }
        for (int i = len/2; i < len; i++) {
            System.arraycopy(grid[i], 0, gridBL[i-len/2], 0, len/2);
            System.arraycopy(grid[i], len/2, gridBR[i-len/2], 0, len/2);
        }
        return new Node4(false, false, construct(gridTL), construct(gridTR), construct(gridBL), construct(gridBR));
    }

    private boolean isAllSame(int[][] grid) {
        int tmp = 0;
        for (int i = 0; i < grid.length; i++) {
            tmp += Arrays.stream(grid[i]).sum();
        }
        return tmp == 0 || tmp == grid.length * grid.length;
    }

    public static void main(String[] args) {
        No427 no427 = new No427();
        System.out.println(no427.construct(new int[][]{{1, 2}, {3, 4}}));
    }

}




