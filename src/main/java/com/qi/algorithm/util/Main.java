package com.qi.algorithm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:  水仙花数
 * Author: Qi
 * Date: 09-28-2021
 */
public class Main {

    public void process(int m, int n){

        List<Integer> ans = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            int bai = i/100;
            int shi = (i%100)/10;
            int ge = (i%10);
            if (Math.pow(bai,3) + Math.pow(shi,3) + Math.pow(ge,3) == i){
                ans.add(i);
            }
        }
        if (ans.size() == 0){
            System.out.println("no");
            return;
        }else {
            System.out.print(ans.get(0));
            for (int i = 1; i < ans.size(); i++) {
                System.out.print(" " + ans.get(i));
            }
        }

    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            m1.process(m, n);
        }
    }
}
