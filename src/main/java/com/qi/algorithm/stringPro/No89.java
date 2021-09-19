package com.qi.algorithm.stringPro;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Gray Code 格雷编码
 *
 * 思路：通过观察得知 每次将前面一位加 0 或者 1 即可，所以加 0 就是本身
 *      加一则要通过位移实现。
 *
 * Author: Qi
 * Date: 09-16-2021
 */
public class No89 {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ans.size()-1; j >=0; j--) {
                ans.add(head+ans.get(j));
            }
            head = head << 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        No89 no89 = new No89();
        List<Integer> integers = no89.grayCode(3);
        System.out.println(integers.toString());
    }
}
