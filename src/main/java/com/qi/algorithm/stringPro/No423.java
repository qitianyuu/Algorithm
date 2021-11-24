package com.qi.algorithm.stringPro;

/**
 * Description: Reconstruct Original Digits from English 从英文中重建数字
 *
 * 思路：暴力解法超时，从而统计例如z只出现在0中这种，然后统计两个的减去一个的
 *
 * Author: Qi
 * Date: 11-24-2021
 */
public class No423 {

    public String originalDigits(String s) {
        String ch = "egfihonsrutwvxz";
        //["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
        //  0   1   2   3   4   5   6   7   8   9   10  11  12  13  14
        int[] letters = new int[15];
        for (int i = 0; i < s.length(); i++) {
            int idx = ch.indexOf(s.charAt(i));
            letters[idx]++;
        }
        int total = s.length();
        StringBuffer sb = new StringBuffer();
        while (total > 0){
            if (letters[14] > 0 && letters[0] > 0 && letters[8] > 0 && letters[5] > 0){
                total -= 4;
                sb.append("0");
                letters[14]--;
                letters[0]--;
                letters[8]--;
                letters[5]--;
                continue;
            }
            if (letters[5] > 0 && letters[6] > 0 && letters[0] > 0){
                total -= 3;
                sb.append("1");
                letters[5]--;
                letters[6]--;
                letters[0]--;
                continue;
            }
            if (letters[10] > 0 && letters[11] > 0 && letters[5] > 0){
                total -= 3;
                sb.append("2");
                letters[10]--;
                letters[11]--;
                letters[5]--;
                continue;
            }
            if (letters[10] > 0 && letters[4] > 0 && letters[8] > 0 && letters[0] > 1){
                total -= 5;
                sb.append("3");
                letters[10]--;
                letters[4]--;
                letters[8]--;
                letters[0]-=2;
                continue;
            }
            if (letters[2] > 0 && letters[5] > 0 && letters[9] > 0 && letters[8] > 0){
                total -= 4;
                sb.append("4");
                letters[2]--;
                letters[5]--;
                letters[9]--;
                letters[8]--;
                continue;
            }
            if (letters[2] > 0 && letters[3] > 0 && letters[12] > 0 && letters[0] > 0){
                total -= 4;
                sb.append("5");
                letters[2]--;
                letters[3]--;
                letters[12]--;
                letters[0]--;
                continue;
            }
            if (letters[7] > 0 && letters[3] > 0 && letters[13] > 0){
                total -= 3;
                sb.append("6");
                letters[7]--;
                letters[3]--;
                letters[13]--;
                continue;
            }
            if (letters[7] > 0 && letters[0] > 1 && letters[12] > 0 && letters[6] > 0){
                total -= 5;
                sb.append("7");
                letters[7]--;
                letters[0]-=2;
                letters[12]--;
                letters[6]--;
                continue;
            }
            if (letters[0] > 0 && letters[3] > 0 && letters[1] > 0 && letters[4] > 0 && letters[10] > 0){
                total -= 5;
                sb.append("8");
                letters[0]--;
                letters[3]--;
                letters[1]--;
                letters[4]--;
                letters[10]--;
                continue;
            }
            if (letters[6] > 1 && letters[3] > 0 && letters[0] > 0){
                total -= 4;
                sb.append("9");
                letters[6]-=2;
                letters[3]--;
                letters[0]--;
                continue;
            }
        }
        return sb.toString();
    }

    public String originalDigits1(String s) {
        String ch = "egfihonsrutwvxz";
        //["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"]
        //  0   1   2   3   4   5   6   7   8   9   10  11  12  13  14
        int[] letters = new int[15];
        for (int i = 0; i < s.length(); i++) {
            int idx = ch.indexOf(s.charAt(i));
            letters[idx]++;
        }
        int[] cnt = new int[10];
        cnt[0] = letters[14];
        cnt[2] = letters[11];
        cnt[4] = letters[9];
        cnt[6] = letters[13];
        cnt[8] = letters[1];

        cnt[3] = letters[4] - cnt[8];
        cnt[5] = letters[2] - cnt[4];
        cnt[7] = letters[7] - cnt[6];

        cnt[1] = letters[5] - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = letters[3] - cnt[5] - cnt[6] - cnt[8];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                sb.append((char)(i+'0'));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        No423 no423 = new No423();
        System.out.println(no423.originalDigits("owoztneoer"));
    }
}
