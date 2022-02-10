package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Simplified Fractions 最简分数
 * Author: Qi
 * Date: 02-10-2022
 */
public class No1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (isRight(j, i)){
                    ans.add(j + "/" + i);
                }
            }
        }
        return ans;
    }

    private boolean isRight(int j, int i) {
        for (int k = 2; k <= j; k++) {
            if (j % k == 0 && i % k == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No1447 no1447 = new No1447();
        System.out.println(no1447.simplifiedFractions(4));
    }
}
