package com.qi.algorithm.stringPro;

import java.util.HashMap;
import java.util.Map;


/**
 * Description: Roman to Integer 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 思路：用map存储索引，然后将字符串拆开，从左至右，当右边大于左边一位时，左一位取反。
 *
 * Author: Qi
 * Date: 08-23-2021
 */
public class No13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('I', 1);
        map1.put('V', 5);
        map1.put('X', 10);
        map1.put('L', 50);
        map1.put('C', 100);
        map1.put('D', 500);
        map1.put('M', 1000);

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            int ic = map1.get(cc);
            if (i != s.length() - 1){
                char cn = s.charAt(i+1);
                int in = map1.get(cn);
                if (in > ic){
                    ic = ic * -1;
                }
            }
            ans += ic;
        }
        return ans;
    }

    public static void main(String[] args) {
        No13 no13 = new No13();
        int a = no13.romanToInt("IX");
        System.out.println(a);
    }

}
