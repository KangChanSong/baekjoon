package com.silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 5000 ; i++) {
            for (int j = 0 ; j <= i ; j ++) {
                if (3 * (i - j) + 5 * j == input) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
